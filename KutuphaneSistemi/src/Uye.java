import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Uye {
    private final int id;
    private final String adSoyad;

    private final Set<Integer> aldigiKitaplar = new HashSet<>();

    public Uye(int id, String adSoyad) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Üye numarası pozitif olmalıdır.");
        }

        if (adSoyad == null || adSoyad.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Üye adı boş olamaz.");
        }

        this.id = id;
        this.adSoyad = adSoyad.trim();
    }

    public int getId() {
        return id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public int getKitapSayisi() {
        return aldigiKitaplar.size();
    }

    public boolean kitapAldiMi(int kitapId) {
        return aldigiKitaplar.contains(kitapId);
    }

    public Set<Integer> getAldigiKitaplar() {
        return Collections.unmodifiableSet(
                new HashSet<>(aldigiKitaplar));
    }

    void kitapEkle(int kitapId) {
        aldigiKitaplar.add(kitapId);
    }

    void kitapCikar(int kitapId) {
        aldigiKitaplar.remove(kitapId);
    }

    @Override
    public String toString() {
        return id + " | " + adSoyad
                + " | Aldığı kitap sayısı: " + getKitapSayisi();
    }
}