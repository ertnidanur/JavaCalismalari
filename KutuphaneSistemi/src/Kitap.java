
class Kitap {
    private final int id;
    private final String ad;
    private final String yazar;

    public Kitap(int id, String ad, String yazar) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Kitap numarası pozitif olmalıdır.");
        }

        if (ad == null || ad.trim().isEmpty()
                || yazar == null || yazar.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Kitap adı ve yazar boş olamaz.");
        }

        this.id = id;
        this.ad = ad.trim();
        this.yazar = yazar.trim();
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getYazar() {
        return yazar;
    }

    @Override
    public String toString() {
        return id + " | " + ad + " | " + yazar;
    }
}
