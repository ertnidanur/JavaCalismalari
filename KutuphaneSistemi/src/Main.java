import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Kutuphane kutuphane = new Kutuphane();

    public static void main(String[] args) {
        ornekVerileriEkle();

        boolean devam = true;

        while (devam) {
            menuGoster();

            try {
                int secim = sayiOku("Seçiminiz: ");

                switch (secim) {
                    case 1: {
                        int id = sayiOku("Kitap numarası: ");
                        String ad = metinOku("Kitap adı: ");
                        String yazar = metinOku("Yazar: ");

                        kutuphane.kitapEkle(id, ad, yazar);
                        System.out.println("Kitap eklendi.");
                        break;
                    }

                    case 2: {
                        int id = sayiOku("Üye numarası: ");
                        String ad = metinOku("Ad soyad: ");

                        kutuphane.uyeEkle(id, ad);
                        System.out.println("Üye eklendi.");
                        break;
                    }

                    case 3:
                        kutuphane.kitaplariListele();
                        break;

                    case 4:
                        kutuphane.uyeleriListele();
                        break;

                    case 5:
                        kutuphane.kitapAra(
                                metinOku("Kitap veya yazar adı: "));
                        break;

                    case 6: {
                        int uyeId = sayiOku("Üye numarası: ");
                        int kitapId = sayiOku("Kitap numarası: ");

                        kutuphane.oduncAl(uyeId, kitapId);
                        break;
                    }

                    case 7: {
                        int uyeId = sayiOku("Üye numarası: ");
                        int kitapId = sayiOku("Kitap numarası: ");

                        kutuphane.iadeEt(uyeId, kitapId);
                        break;
                    }

                    case 8: {
                        int uyeId = sayiOku("Üye numarası: ");
                        int kitapId = sayiOku("Kitap numarası: ");

                        kutuphane.beklemeSirasinaGir(uyeId, kitapId);
                        break;
                    }

                    case 9: {
                        int uyeId = sayiOku("Üye numarası: ");
                        int kitapId = sayiOku("Kitap numarası: ");

                        kutuphane.beklemeSirasindanCik(uyeId, kitapId);
                        break;
                    }

                    case 10:
                        kutuphane.beklemeSirasiniGoster(
                                sayiOku("Kitap numarası: "));
                        break;

                    case 11:
                        kutuphane.uyeninKitaplariniGoster(
                                sayiOku("Üye numarası: "));
                        break;

                    case 12:
                        kutuphane.islemGecmisiniGoster();
                        break;

                    case 13:
                        kutuphane.ozetGoster();
                        break;

                    case 0:
                        devam = false;
                        System.out.println("Program kapatıldı.");
                        break;

                    default:
                        System.out.println("Geçersiz seçim.");
                }

            } catch (NumberFormatException hata) {
                System.out.println("Geçerli bir tam sayı girmelisin.");

            } catch (IllegalArgumentException hata) {
                System.out.println("İşlem yapılamadı: " + hata.getMessage());
            }
        }

        scanner.close();
    }

    private static void ornekVerileriEkle() {
        kutuphane.kitapEkle(1, "Küçük Prens",
                "Antoine de Saint-Exupéry");

        kutuphane.kitapEkle(2, "Satranç", "Stefan Zweig");
        kutuphane.kitapEkle(3, "Dönüşüm", "Franz Kafka");
        kutuphane.kitapEkle(4, "Beyaz Diş", "Jack London");

        kutuphane.uyeEkle(1, "Nida");
        kutuphane.uyeEkle(2, "Ayşe");
        kutuphane.uyeEkle(3, "Ali");
    }

    private static void menuGoster() {
        System.out.println("\n--- KÜTÜPHANE SİSTEMİ ---");
        System.out.println("1  - Kitap ekle");
        System.out.println("2  - Üye ekle");
        System.out.println("3  - Kitapları listele");
        System.out.println("4  - Üyeleri listele");
        System.out.println("5  - Kitap ara");
        System.out.println("6  - Kitap ödünç al");
        System.out.println("7  - Kitap iade et");
        System.out.println("8  - Bekleme sırasına gir");
        System.out.println("9  - Bekleme sırasından çık");
        System.out.println("10 - Kitabın bekleme sırasını göster");
        System.out.println("11 - Üyenin aldığı kitapları göster");
        System.out.println("12 - İşlem geçmişini göster");
        System.out.println("13 - Kütüphane özeti");
        System.out.println("0  - Çıkış");
    }

    private static String metinOku(String mesaj) {
        System.out.print(mesaj);
        return scanner.nextLine().trim();
    }

    private static int sayiOku(String mesaj) {
        return Integer.parseInt(metinOku(mesaj));
    }
}