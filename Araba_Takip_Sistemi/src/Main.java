import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AracYonetimi yonetim = new AracYonetimi();

    public static void main(String[] args) {
        boolean devam = true;

        while (devam) {
            menuYazdir();

            try {
                int secim = tamSayiOku("Seçiminiz: ");

                switch (secim) {
                    case 1:
                        aracEkle();
                        break;

                    case 2:
                        yonetim.araclariListele();
                        break;

                    case 3:
                        kilometreGuncelle();
                        break;

                    case 4:
                        bakimEkle();
                        break;

                    case 5:
                        bakimGecmisiGoster();
                        break;

                    case 0:
                        devam = false;
                        System.out.println("Program kapatıldı.");
                        break;

                    default:
                        System.out.println("Geçersiz seçim.");
                }
            } catch (IllegalArgumentException e) {
                // NumberFormatException da bu catch tarafından yakalanır.
                System.out.println("İşlem yapılamadı: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void menuYazdir() {
        System.out.println("\n--- ARAÇ BAKIM TAKİP ---");
        System.out.println("1 - Araç ekle");
        System.out.println("2 - Araçları ve bakım durumlarını listele");
        System.out.println("3 - Kilometre güncelle");
        System.out.println("4 - Bakım / masraf kaydı ekle");
        System.out.println("5 - Aracın bakım geçmişini göster");
        System.out.println("0 - Çıkış");
    }

    private static void aracEkle() {
        String plaka = metinOku("Plaka: ");
        String marka = metinOku("Marka: ");
        String model = metinOku("Model: ");
        int kilometre = tamSayiOku("Mevcut kilometre: ");
        int sonBakimKm = tamSayiOku(
                "Son periyodik bakım kilometresi: ");

        yonetim.aracEkle(plaka, marka, model, kilometre, sonBakimKm);

        System.out.println("Araç eklendi.");
    }

    private static void kilometreGuncelle() {
        Arac arac = aracSec();

        int yeniKilometre = tamSayiOku(
                "Yeni kilometre (mevcut: "
                        + arac.getKilometre() + "): ");

        arac.kilometreGuncelle(yeniKilometre);

        System.out.println("Kilometre güncellendi.");
        System.out.println(arac.bakimDurumuGetir());
    }

    private static void bakimEkle() {
        Arac arac = aracSec();

        String aciklama = metinOku("Yapılan işlem: ");
        int kilometre = tamSayiOku("İşlem sırasındaki kilometre: ");
        double tutar = ondalikSayiOku("Tutar (TL): ");

        String cevap = metinOku(
                "Bu işlem periyodik bakım mı? (E/H): ");

        if (!cevap.equalsIgnoreCase("E")
                && !cevap.equalsIgnoreCase("H")) {
            throw new IllegalArgumentException("E veya H yazmalısınız.");
        }

        BakimKaydi kayit = new BakimKaydi(
                aciklama, LocalDate.now(), kilometre, tutar);

        arac.bakimEkle(kayit, cevap.equalsIgnoreCase("E"));

        System.out.println("Bakım kaydı eklendi.");
    }

    private static void bakimGecmisiGoster() {
        Arac arac = aracSec();

        System.out.println("\n" + arac);
        arac.bakimlariYazdir();
    }

    private static Arac aracSec() {
        String plaka = metinOku("Araç plakası: ");
        Arac arac = yonetim.aracBul(plaka);

        if (arac == null) {
            throw new IllegalArgumentException("Araç bulunamadı.");
        }

        return arac;
    }

    private static String metinOku(String mesaj) {
        System.out.print(mesaj);
        return scanner.nextLine().trim();
    }

    private static int tamSayiOku(String mesaj) {
        return Integer.parseInt(metinOku(mesaj));
    }

    private static double ondalikSayiOku(String mesaj) {
        return Double.parseDouble(
                metinOku(mesaj).replace(',', '.'));
    }
}