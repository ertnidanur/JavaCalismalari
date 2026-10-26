# Kütüphane ve Ödünç Kitap Takip Sistemi

Java koleksiyonlarını farklı ihtiyaçlarda kullanmak için hazırlanmış konsol uygulaması. Kitap ve üye kaydı, ödünç alma, iade, bekleme sırası ve işlem geçmişi içerir.

## Özellikler

- Numaraları benzersiz kitap ve üyeler ekleme
- Kitapları eklenme sırasına, üyeleri numaralarına göre listeleme
- Kitap veya yazar adına göre arama
- Bir üyeye en fazla 3 kitap ödünç verme
- 14 günlük ödünç süresi ve gecikme kontrolü
- Kitap iade etme ve üyenin kitaplarını görüntüleme
- Ödünçteki kitap için bekleme sırasına girme ve sıradan çıkma
- İşlem geçmişini ve kütüphane özetini görüntüleme

## Koleksiyonlar

| Koleksiyon | Kullanım |
| --- | --- |
| `LinkedHashMap<Integer, Kitap>` | Kitapları numarayla bulur ve eklenme sırasını korur. |
| `HashMap<Integer, Uye>` | Üyeleri numarayla bulur. |
| `HashMap<Integer, OduncKaydi>` | Kitap numarasına göre aktif ödünç kayıtlarını tutar. |
| `HashSet<Integer>` | Üyenin aldığı kitap numaralarını tekrar olmadan saklar. |
| `HashMap<Integer, Queue<Integer>>` | Her kitap için ayrı bekleme sırası tutar. |
| `ArrayDeque<Integer>` | Bekleme sırasını ilk giren ilk çıkar mantığıyla yönetir. |
| `ArrayList<String>` | İşlem geçmişini sıralı olarak saklar. |

## Sınıflar

- **Kitap:** Kitap numarası, adı ve yazarı.
- **Uye:** Üye bilgileri ve üyenin aldığı kitap numaraları.
- **OduncKaydi:** Kitap, üye, alış ve son teslim tarihleri.
- **Kutuphane:** Kayıtlar, ödünç işlemleri, arama ve sıra yönetimi.
- **Main:** Konsol menüsü ve örnek veriler.

## Çalıştırma

JDK 8 veya üzeri gerekir. Paylaşılan tek dosyalık sürümü `src/Main.java` olarak kaydedin. Bu sürümde paket bildirimi yoktur.

Proje klasöründe:

```bash
javac -encoding UTF-8 -d out src/Main.java
java -cp out Main
```

IDE kullanıyorsanız `Main` sınıfını çalıştırabilirsiniz. Sınıfları ayrı dosyalara ayırdıysanız IDE üzerinden tüm kaynakları derleyin ve paket düzenini koruyun.

## Örnek Senaryo

Başlangıçta 4 kitap ve 3 üye eklenir:

1. Nida (üye 1), Küçük Prens'i (kitap 1) ödünç alır.
2. Ayşe (üye 2), aynı kitap için bekleme sırasına girer.
3. Nida kitabı iade eder.
4. Kitap rafta olsa da sıradaki Ayşe'ye öncelik verilir.
5. Ayşe ödünç alma işlemini yaptığında sıradan çıkarılır.

Kitap otomatik olarak sıradaki üyeye verilmez. Sıradaki üye kitap limitine ulaştıysa önce bir kitabını iade etmeli veya bekleme sırasından çıkmalıdır.

## Mevcut Sınırlar

- Veriler yalnızca bellekte tutulur; program kapanınca silinir.
- Her kitap numarası tek bir fiziksel kitabı temsil eder.
- Dosyaya kayıt, veritabanı ve grafik arayüz yoktur.
- Bekleme önceliği için süre sonu veya otomatik iptal bulunmaz.
- Para cezası hesaplanmaz.

Öğrenme ve pratik amacıyla hazırlanmıştır.
