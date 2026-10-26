package ornek;

public class Araba extends Araclar {

    private String renk;
    private double mileage;

    public Araba() {
    }

    public Araba(String marka, String model, String renk, int year) {
        super(marka, model, year, 4);
        this.renk = renk;
    }

    public String getRenk() { return renk; }
    public void setRenk(String renk) { this.renk = renk; }

    public double getMileage() { return mileage; }
    public void setMileage(double mileage) { this.mileage = mileage; }

    @Override

    public void cagir() {
        System.out.println("Car called!");
    }

    @Override

    public void performJob() {
        System.out.println("Car is providing service");
    }
} 