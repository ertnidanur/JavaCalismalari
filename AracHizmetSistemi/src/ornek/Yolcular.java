package ornek;

public class Yolcular extends Person {
	private String adres = "Belirtilmedi";
    private int id;

    public Yolcular(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void bilgileriGoster() {
        System.out.println(this);
    }
    @Override
    public void performJob() {
        System.out.println("This is a Passenger");
    }
    @Override
    public String toString() {
        return super.toString() 
             + " | ID: " + id 
             + " | Adres: " + adres;
    }
}
