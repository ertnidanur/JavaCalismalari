import java.time.LocalDate;


class BakimKaydi {
    private final String aciklama;
    private final LocalDate tarih;
    private final int kilometre;
    private final double tutar;

    public BakimKaydi(String aciklama, LocalDate tarih,
                      int kilometre, double tutar) {

        if (aciklama == null || aciklama.isBlank()) {
            throw new IllegalArgumentException(
                    "Bakım açıklaması boş olamaz.");
        }

        if (tarih == null || tarih.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Bakım tarihi bugün veya geçmiş bir tarih olmalıdır.");
        }

        if (kilometre < 0 || !Double.isFinite(tutar) || tutar < 0) {
            throw new IllegalArgumentException(
                    "Kilometre ve tutar negatif olmayan değerler olmalıdır.");
        }

        this.aciklama = aciklama.trim();
        this.tarih = tarih;
        this.kilometre = kilometre;
        this.tutar = tutar;
    }

    public int getKilometre() {
        return kilometre;
    }

    public double getTutar() {
        return tutar;
    }

    @Override
    public String toString() {
        return String.format(
                "%s | %s | %,d km | %.2f TL",
                tarih, aciklama, kilometre, tutar);
    }
}