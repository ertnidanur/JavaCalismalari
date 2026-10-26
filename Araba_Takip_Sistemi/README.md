# Araba Takip Sistemi

Araçların kilometre bilgilerini, bakım geçmişini ve kaydedilen bakım masraflarını takip etmek için hazırlanmış Java konsol uygulaması.

## Özellikler

- Plaka, marka, model ve kilometre bilgileriyle araç ekleme
- Kayıtlı araçları listeleme
- Mevcut kilometreden daha düşük bir değer girilmesini engelleyerek kilometre güncelleme
- Bakım açıklaması, kilometre ve tutar bilgileriyle bakım kaydetme
- Araç bazında bakım geçmişini ve toplam bakım masrafını görüntüleme
- Periyodik bakıma kalan veya geciken kilometreyi hesaplama
- Aynı plakanın tekrar kaydedilmesini engelleme

## Bakım Hesabı

Örnek bakım aralığı **10.000 km** olarak belirlenmiştir:

```
Kalan kilometre = Son periyodik bakım kilometresi + 10.000 − Mevcut kilometre
```

Periyodik bakım olarak işaretlenmeyen işlemler, son periyodik bakım kilometresi bilgisini değiştirmez. Hesaplama araç modeline veya geçen zamana göre bakım önerisi üretmez.

## Kullanılan Konular

Sınıflar, kapsülleme, koleksiyonlar, tarih işlemleri, konsol girdileri ve exception yönetimi.

## Çalıştırma

1. Projeyi JDK kurulu bir Java IDE'sinde açın.
2. Kaynak dosyalarının paket bildirimlerine uygun klasörlerde bulunduğundan emin olun.
3. `main` metodunu içeren `Main` sınıfını çalıştırın.
4. Konsoldaki menüden işlem seçin.

## Mevcut Sınırlar

- Kayıtlar bellekte tutulur ve program kapandığında silinir.
- Veritabanı, dosyaya kayıt ve grafik arayüz bulunmaz.
- Bakım aralığı tüm araçlar için sabittir.

Öğrenme ve pratik amacıyla geliştirilmiştir.
