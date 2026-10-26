# Araç Hizmet Sistemi — Java OOP Çalışması

Farklı araç ve kişi türlerini sınıf hiyerarşileriyle modelleyen Java konsol çalışması. Amaç, kalıtım ve çok biçimliliğin kullanımını örneklemektir.

## İçerik

- `Araclar` soyut sınıfından türeyen araba ve motosiklet sınıfları
- `Sedan`, `ElectricCar`, `Scooter` ve `RacingMotorcycle` alt sınıfları
- `Person` soyut sınıfından türeyen sürücü ve yolcu sınıfları
- `VIPSurucu` sınıfıyla çok seviyeli kalıtım ve `final` kullanımı
- Araçlara sürücü atama
- Araç ve sürücü bilgilerinin konsolda gösterilmesi
- Sürücü yaşı ve bazı sayısal değerler için doğrulama

## Çok Biçimlilik

`MainTest` içinde farklı araç türleri bir `Araclar[]` dizisinde tutulur. Dizideki nesneler üzerinden `performJob()` ve `cagir()` metotları çağrılır. Çalışan metot, nesnenin gerçek sınıfına göre belirlenir.

## Kullanılan Konular

- Soyut sınıflar ve soyut metotlar
- Çok seviyeli kalıtım
- Metot ezme (`@Override`) ve çok biçimlilik
- Kapsülleme, getter ve setter metotları
- Yapıcı metotlar ve `super`
- Nesne ilişkileri ve nesne dizileri
- `toString()`, `final` ve exception yönetimi

## Çalıştırma

Tüm Java dosyalarını `src/ornek` klasöründe tutun. Proje klasöründe terminal açarak:

```bash
javac -encoding UTF-8 -d out src/ornek/*.java
java -cp out ornek.MainTest
```

Alternatif olarak IDE'den `MainTest` sınıfını çalıştırabilirsiniz. Derleme için yalnızca JRE değil, JDK gerekir.

## Mevcut Sınırlar

Örnek nesneler kod içinde oluşturulur; kullanıcı menüsü veya kalıcı veri saklama bulunmaz. Bu çalışma, tamamlanmış bir ulaşım veya rezervasyon uygulaması değildir. Sürücü ekleme ve puan döndürme gibi bazı metotlar yalnızca örnek davranış içerir.
