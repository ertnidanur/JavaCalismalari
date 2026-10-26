import java.util.ArrayList;
import java.util.List;

class Arac {
    private static final int BAKIM_ARALIGI = 10_000;

    private final String plaka;
    private final String marka;
    private final String model;
    private int kilometre;
    private int sonPeriyodikBakimKm;

    private final List<BakimKaydi> bakimlar = new ArrayList<>();

    public Arac(String plaka, String marka, String model,
                int kilometre, int sonPeriyodikBakimKm) {

        if (plaka == null || plaka.isBlank()
                || marka == null || marka.isBlank()
                || model == null || model.isBlank()) {

            throw new IllegalArgumentException(
                    "Plaka, marka ve model boş olamaz.");
        }

        if (kilometre < 0 || sonPeriyodikBakimKm < 0
                || sonPeriyodikBakimKm > kilometre) {

            throw new IllegalArgumentException(
                    "Kilometre bilgileri geçersiz.");
        }

        this.plaka = plaka;
        this.marka = marka.trim();
        this.model = model.trim();
        this.kilometre = kilometre;
        this.sonPeriyodikBakimKm = sonPeriyodikBakimKm;
    }

    public String getPlaka() {
        return plaka;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void kilometreGuncelle(int yeniKilometre) {
        if (yeniKilometre < kilometre) {
            throw new IllegalArgumentException(
                    "Yeni kilometre mevcut kilometreden küçük olamaz.");
        }

        kilometre = yeniKilometre;
    }

    public void bakimEkle(BakimKaydi kayit, boolean periyodikBakim) {
        if (kayit == null) {
            throw new IllegalArgumentException("Bakım kaydı boş olamaz.");
        }

        if (kayit.getKilometre() > kilometre) {
            throw new IllegalArgumentException(
                    "Bakım kilometresi aracın mevcut kilometresini geçemez.");
        }

        if (periyodikBakim) {
            sonPeriyodikBakimKm = Math.max(
                    sonPeriyodikBakimKm, kayit.getKilometre());
        }

        bakimlar.add(kayit);
    }

    public double toplamMasrafHesapla() {
        double toplam = 0;

        for (BakimKaydi kayit : bakimlar) {
            toplam += kayit.getTutar();
        }

        return toplam;
    }

    public String bakimDurumuGetir() {
        long kalanKm = (long) sonPeriyodikBakimKm
                + BAKIM_ARALIGI - kilometre;

        if (kalanKm < 0) {
            return "Periyodik bakım " + (-kalanKm) + " km gecikti.";
        }

        if (kalanKm == 0) {
            return "Periyodik bakım zamanı geldi.";
        }

        return "Sonraki periyodik bakıma " + kalanKm + " km kaldı.";
    }

    public void bakimlariYazdir() {
        if (bakimlar.isEmpty()) {
            System.out.println("Bu araç için bakım kaydı yok.");
            return;
        }

        for (BakimKaydi kayit : bakimlar) {
            System.out.println(kayit);
        }

        System.out.printf(
                "Kaydedilen toplam masraf: %.2f TL%n",
                toplamMasrafHesapla());
    }

    @Override
    public String toString() {
        return plaka + " | " + marka + " " + model
                + " | " + kilometre + " km"
                + " | " + bakimDurumuGetir();
    }
}