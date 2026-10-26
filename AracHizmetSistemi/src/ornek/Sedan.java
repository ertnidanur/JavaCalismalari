package ornek;

public class Sedan extends Araba {
	private int koltukSayisi;  
    private boolean otomatikMi;

    public Sedan(String marka, String model, String renk, int year,
                 Suruculer surucu, double price, double yakitTuketimi) {
        super(marka, model, renk, year);
        this.koltukSayisi = getKapasite();
        setSurucu(surucu);
        setPrice(price);
        setYakitTuketimi(yakitTuketimi);
    }

    public void setOtomatikMi(boolean otomatikMi) { this.otomatikMi = otomatikMi; }
    public boolean isOtomatikMi() { return otomatikMi; }

    @Override

    public void performJob() {
        System.out.println("Car is providing service");
        Suruculer s = getSurucu();
        if (s == null) {
            System.out.println("Araca sürücü atanmamış.");
            return;
        }
        System.out.println("Sedan -> Car -> Name: " + s.getName()
                + ", Age: " + s.getAge()
                + ", Vehicle: " + getMarka() + " " + getModel()
                + ", Color: " + getRenk()
                + ", Year: " + getYear());
        System.out.println("Price: " + getPrice());
        System.out.println("Fuel (100km): " + getYakitTuketimi());
    }
    @Override
    public String toString() {
        return "Sedan | " + getMarka() + " " + getModel()
             + " | Renk: " + getRenk()
             + " | Koltuk: " + koltukSayisi
             + " | Otomatik: " + otomatikMi
             + " | Fiyat: " + getPrice() + " TL"
             + " | Yakit: " + getYakitTuketimi() + "L/100km";
    }

}
