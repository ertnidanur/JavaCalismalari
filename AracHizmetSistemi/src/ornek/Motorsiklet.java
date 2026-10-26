package ornek;


public class Motorsiklet extends Araclar {

    private String motorHacmi; 
    private boolean sepetliMi;
    private String sogutmaTipi; 

    public Motorsiklet() {
    }

    public Motorsiklet(String marka, String model, int year, int kapasite,
                       String motorHacmi, boolean sepetliMi, String sogutmaTipi) {
        super(marka, model, year, kapasite);
        this.motorHacmi = motorHacmi;
        this.sepetliMi = sepetliMi;
        this.sogutmaTipi = sogutmaTipi;
    }

    public String getMotorHacmi() { return motorHacmi; }
    public void setMotorHacmi(String motorHacmi) { this.motorHacmi = motorHacmi; }

    public boolean isSepetliMi() { return sepetliMi; }
    public void setSepetliMi(boolean sepetliMi) { this.sepetliMi = sepetliMi; }

    public String getSogutmaTipi() { return sogutmaTipi; }
    public void setSogutmaTipi(String sogutmaTipi) { this.sogutmaTipi = sogutmaTipi; }

    @Override
    public void cagir() {
        System.out.println("Motorcycle called!");
    }

    @Override
    public void performJob() {
        System.out.println("Motorcycle is providing service");
        
    }
}
