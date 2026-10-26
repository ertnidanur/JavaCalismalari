import java.util.ArrayList;
import java.util.List;

class AracYonetimi {
    private final List<Arac> araclar = new ArrayList<>();

    public static String plakaDuzenle(String plaka) {
        if (plaka == null) {
            throw new IllegalArgumentException("Plaka boş olamaz.");
        }

        return plaka.replaceAll("\\s+", "")
                .toUpperCase(java.util.Locale.ROOT);
    }

    public void aracEkle(String plaka, String marka, String model,
                         int kilometre, int sonBakimKm) {

        String duzenliPlaka = plakaDuzenle(plaka);

        if (aracBul(duzenliPlaka) != null) {
            throw new IllegalArgumentException(
                    "Bu plakaya ait araç zaten kayıtlı.");
        }

        Arac arac = new Arac(
                duzenliPlaka, marka, model, kilometre, sonBakimKm);

        araclar.add(arac);
    }

    public Arac aracBul(String plaka) {
        String duzenliPlaka = plakaDuzenle(plaka);

        for (Arac arac : araclar) {
            if (arac.getPlaka().equals(duzenliPlaka)) {
                return arac;
            }
        }

        return null;
    }

    public void araclariListele() {
        if (araclar.isEmpty()) {
            System.out.println("Henüz araç eklenmedi.");
            return;
        }

        for (Arac arac : araclar) {
            System.out.println(arac);
        }
    }
}