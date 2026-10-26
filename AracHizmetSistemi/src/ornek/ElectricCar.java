package ornek;

public class ElectricCar extends Araba {

    public ElectricCar(String marka, String model, String renk, int year,
                       Suruculer surucu, double price, double yakitTuketimi) {
        super(marka, model, renk, year);
        setSurucu(surucu);
        setPrice(price);
        setYakitTuketimi(yakitTuketimi);
    }
    @Override
    public String toString() {
        return "ElectricCar | " + getMarka() + " " + getModel()
             + " | Renk: " + getRenk()
             + " | Fiyat: " + getPrice() + " TL"
             + " | Enerji: " + getYakitTuketimi() + " kWh/100km";
    }

    @Override

    public void performJob() {
        System.out.println("Car is providing service");
        Suruculer s = getSurucu();
        if (s == null) {
            System.out.println("Araca sürücü atanmamış.");
            return;
        }
        System.out.println("ElectricCar -> Car -> Name: " + s.getName()
                + ", Age: " + s.getAge()
                + ", Vehicle: " + getMarka() + " " + getModel()
                + ", Color: " + getRenk()
                + ", Year: " + getYear());
        System.out.println("Price: " + getPrice());
        System.out.println("Energy (kWh/100km): " + getYakitTuketimi());
    }
}
