package ornek;

public class Scooter extends Motorsiklet {

    public Scooter(String marka, String model, String motorHacmi,
                   Suruculer surucu, double price, double yakitTuketimi) {
        super(marka, model, 0, 1, motorHacmi, false, "Hava");
        setSurucu(surucu);
        setPrice(price);
        setYakitTuketimi(yakitTuketimi);
    }
    @Override
    public String toString() {
        return "Scooter | " + getMarka() + " " + getModel()
             + " | Motor: " + getMotorHacmi()
             + " | Fiyat: " + getPrice() + " TL"
             + " | Yakit: " + getYakitTuketimi() + "L/100km";
    }


    @Override


    public void performJob() {
        System.out.println("Motorcycle is providing service");
        Suruculer s = getSurucu();
        if (s == null) {
            System.out.println("Araca sürücü atanmamış.");
            return;
        }
        System.out.println("Scooter -> Motorcycle -> Name: " + s.getName()
                + ", Age: " + s.getAge()
                + ", Vehicle: " + getMarka() + " " + getModel()
                + ", Engine: " + getMotorHacmi());
        System.out.println("Price: " + getPrice());
        System.out.println("Fuel (100km): " + getYakitTuketimi());
    }
}
