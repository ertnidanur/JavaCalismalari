import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Kutuphane {
    private static final int KITAP_LIMITI = 3;
    private static final int ODUNC_GUN_SAYISI = 14;

    private final Map<Integer, Kitap> kitaplar =
            new LinkedHashMap<>();

    private final Map<Integer, Uye> uyeler =
            new HashMap<>();

    private final Map<Integer, OduncKaydi> aktifOduncler =
            new HashMap<>();

    private final Map<Integer, Queue<Integer>> beklemeListeleri =
            new HashMap<>();

    private final List<String> islemGecmisi =
            new ArrayList<>();

    public void kitapEkle(int id, String ad, String yazar) {
        if (kitaplar.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Bu numarayla kayıtlı bir kitap zaten var.");
        }

        Kitap kitap = new Kitap(id, ad, yazar);
        kitaplar.put(id, kitap);

        islemKaydet("Kitap eklendi: " + kitap.getAd());
    }

    public void uyeEkle(int id, String adSoyad) {
        if (uyeler.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Bu numarayla kayıtlı bir üye zaten var.");
        }

        Uye uye = new Uye(id, adSoyad);
        uyeler.put(id, uye);

        islemKaydet("Üye eklendi: " + uye.getAdSoyad());
    }

    private Kitap kitapBul(int kitapId) {
        Kitap kitap = kitaplar.get(kitapId);

        if (kitap == null) {
            throw new IllegalArgumentException("Kitap bulunamadı.");
        }

        return kitap;
    }

    private Uye uyeBul(int uyeId) {
        Uye uye = uyeler.get(uyeId);

        if (uye == null) {
            throw new IllegalArgumentException("Üye bulunamadı.");
        }

        return uye;
    }

    public void kitaplariListele() {
        if (kitaplar.isEmpty()) {
            System.out.println("Kayıtlı kitap yok.");
            return;
        }

        for (Kitap kitap : kitaplar.values()) {
            String durum;

            if (aktifOduncler.containsKey(kitap.getId())) {
                durum = "Ödünç verildi";
            } else {
                Queue<Integer> sira =
                        beklemeListeleri.get(kitap.getId());

                durum = sira != null && !sira.isEmpty()
                        ? "Rafta — bekleme sırası var"
                        : "Rafta";
            }

            System.out.println(kitap + " | " + durum);
        }
    }

    public void uyeleriListele() {
        if (uyeler.isEmpty()) {
            System.out.println("Kayıtlı üye yok.");
            return;
        }

        // HashMap sıralı değildir; listeye aktarıp ID'ye göre sıralıyoruz.
        List<Uye> siraliUyeler = new ArrayList<>(uyeler.values());

        siraliUyeler.sort(Comparator.comparingInt(Uye::getId));

        for (Uye uye : siraliUyeler) {
            System.out.println(uye);
        }
    }

    public void kitapAra(String aranan) {
        if (aranan == null || aranan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Arama metni boş olamaz.");
        }

        Locale turkce = Locale.forLanguageTag("tr-TR");
        String arama = aranan.trim().toLowerCase(turkce);

        boolean bulundu = false;

        for (Kitap kitap : kitaplar.values()) {
            boolean adEslesiyor =
                    kitap.getAd().toLowerCase(turkce).contains(arama);

            boolean yazarEslesiyor =
                    kitap.getYazar().toLowerCase(turkce).contains(arama);

            if (adEslesiyor || yazarEslesiyor) {
                System.out.println(kitap);
                bulundu = true;
            }
        }

        if (!bulundu) {
            System.out.println("Aramaya uygun kitap bulunamadı.");
        }
    }

    public void oduncAl(int uyeId, int kitapId) {
        Uye uye = uyeBul(uyeId);
        Kitap kitap = kitapBul(kitapId);

        if (uye.kitapAldiMi(kitapId)) {
            throw new IllegalArgumentException(
                    "Bu kitap zaten bu üyede.");
        }

        if (aktifOduncler.containsKey(kitapId)) {
            throw new IllegalArgumentException(
                    "Kitap başka bir üyede. Bekleme sırasına girebilirsin.");
        }

        if (uye.getKitapSayisi() >= KITAP_LIMITI) {
            throw new IllegalArgumentException(
                    "Bir üye en fazla " + KITAP_LIMITI
                            + " kitap alabilir.");
        }

        Queue<Integer> sira = beklemeListeleri.get(kitapId);

        if (sira != null && !sira.isEmpty()) {
            if (!Objects.equals(sira.peek(), uyeId)) {
                throw new IllegalArgumentException(
                        "Bu kitap için öncelik sıradaki üyeye ait.");
            }

            sira.poll();

            if (sira.isEmpty()) {
                beklemeListeleri.remove(kitapId);
            }
        }

        OduncKaydi kayit = new OduncKaydi(
                kitapId, uyeId, LocalDate.now(), ODUNC_GUN_SAYISI);

        aktifOduncler.put(kitapId, kayit);
        uye.kitapEkle(kitapId);

        islemKaydet(uye.getAdSoyad()
                + " kitabı aldı: " + kitap.getAd());

        System.out.println("Kitap ödünç verildi.");
        System.out.println(
                "Son teslim tarihi: " + kayit.getSonTeslimTarihi());
    }

    public void iadeEt(int uyeId, int kitapId) {
        Uye uye = uyeBul(uyeId);
        Kitap kitap = kitapBul(kitapId);

        OduncKaydi kayit = aktifOduncler.get(kitapId);

        if (kayit == null || kayit.getUyeId() != uyeId) {
            throw new IllegalArgumentException(
                    "Bu kitap bu üyeye ödünç verilmemiş.");
        }

        aktifOduncler.remove(kitapId);
        uye.kitapCikar(kitapId);

        islemKaydet(uye.getAdSoyad()
                + " kitabı iade etti: " + kitap.getAd());

        System.out.println("Kitap iade edildi.");

        if (kayit.geciktiMi()) {
            System.out.println("Kitap son teslim tarihinden sonra getirildi.");
        }

        Queue<Integer> sira = beklemeListeleri.get(kitapId);

        if (sira != null && !sira.isEmpty()) {
            Uye siradaki = uyeBul(sira.peek());

            System.out.println(
                    "Öncelik verilen üye: " + siradaki.getAdSoyad());
        }
    }

    public void beklemeSirasinaGir(int uyeId, int kitapId) {
        Uye uye = uyeBul(uyeId);
        Kitap kitap = kitapBul(kitapId);

        if (uye.kitapAldiMi(kitapId)) {
            throw new IllegalArgumentException(
                    "Elindeki kitap için sıraya giremezsin.");
        }

        if (!aktifOduncler.containsKey(kitapId)) {
            throw new IllegalArgumentException(
                    "Kitap rafta. Ödünç almayı deneyebilirsin.");
        }

        Queue<Integer> sira = beklemeListeleri.get(kitapId);

        if (sira == null) {
            sira = new ArrayDeque<>();
            beklemeListeleri.put(kitapId, sira);
        }

        if (sira.contains(uyeId)) {
            throw new IllegalArgumentException(
                    "Bu kitap için zaten sıradasın.");
        }

        sira.offer(uyeId);

        islemKaydet(uye.getAdSoyad()
                + " bekleme sırasına girdi: " + kitap.getAd());

        System.out.println("Bekleme sırasına eklendin.");
    }

    public void beklemeSirasindanCik(int uyeId, int kitapId) {
        uyeBul(uyeId);
        kitapBul(kitapId);

        Queue<Integer> sira = beklemeListeleri.get(kitapId);

        if (sira == null || !sira.remove(Integer.valueOf(uyeId))) {
            throw new IllegalArgumentException(
                    "Bu kitap için bekleme sırasında değilsin.");
        }

        if (sira.isEmpty()) {
            beklemeListeleri.remove(kitapId);
        }

        islemKaydet("Üye " + uyeId
                + ", kitap " + kitapId + " için sıradan çıktı.");

        System.out.println("Bekleme sırasından çıktın.");
    }

    public void beklemeSirasiniGoster(int kitapId) {
        Kitap kitap = kitapBul(kitapId);
        Queue<Integer> sira = beklemeListeleri.get(kitapId);

        System.out.println("Kitap: " + kitap.getAd());

        if (sira == null || sira.isEmpty()) {
            System.out.println("Bekleyen üye yok.");
            return;
        }

        int siraNo = 1;

        for (int uyeId : sira) {
            Uye uye = uyeBul(uyeId);

            System.out.println(
                    siraNo + ". " + uye.getAdSoyad());

            siraNo++;
        }
    }

    public void uyeninKitaplariniGoster(int uyeId) {
        Uye uye = uyeBul(uyeId);

        System.out.println("Üye: " + uye.getAdSoyad());

        if (uye.getKitapSayisi() == 0) {
            System.out.println("Üyenin aldığı kitap yok.");
            return;
        }

        List<Integer> kitapNumaralari =
                new ArrayList<>(uye.getAldigiKitaplar());

        Collections.sort(kitapNumaralari);

        for (int kitapId : kitapNumaralari) {
            Kitap kitap = kitapBul(kitapId);
            OduncKaydi kayit = aktifOduncler.get(kitapId);

            System.out.println(
                    kitap
                            + " | Teslim: " + kayit.getSonTeslimTarihi()
                            + " | " + (kayit.geciktiMi()
                            ? "Gecikti" : "Süresi devam ediyor"));
        }
    }

    private void islemKaydet(String aciklama) {
        islemGecmisi.add(LocalDate.now() + " | " + aciklama);
    }

    public void islemGecmisiniGoster() {
        if (islemGecmisi.isEmpty()) {
            System.out.println("Henüz işlem yok.");
            return;
        }

        for (String islem : islemGecmisi) {
            System.out.println(islem);
        }
    }

    public void ozetGoster() {
        System.out.println("Kitap sayısı: " + kitaplar.size());
        System.out.println("Üye sayısı: " + uyeler.size());
        System.out.println("Ödünçteki kitap: " + aktifOduncler.size());

        System.out.println(
                "Raftaki kitap: "
                        + (kitaplar.size() - aktifOduncler.size()));
    }
}