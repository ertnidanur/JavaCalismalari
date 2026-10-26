package ornek;


public abstract class Araclar {

    private String marka;
    private String model;
    private String plaka;
    private int year;
    private int kapasite;
    private double price;
    private double yakitTuketimi;
    private Suruculer surucu;

    public Araclar() {
        this.marka = "Bilinmeyen";
        this.model = "Girilmemiş model";
        this.year = 0;
        this.kapasite = 0;
    }

    public Araclar(String marka, String model, int year, int kapasite) {
        this.marka = marka;
        this.model = model;
        setYear(year);
        setKapasite(kapasite);
    }
    public abstract void cagir();
    public abstract void performJob();

    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year < 0) throw new IllegalArgumentException("Year geçersiz.");
        this.year = year;
    }

    public int getKapasite() { return kapasite; }
    public void setKapasite(int kapasite) {
        if (kapasite < 0) throw new IllegalArgumentException("Kapasite geçersiz.");
        this.kapasite = kapasite;
    }

    public String getPlaka() { return plaka; }
    public void setPlaka(String plaka) { this.plaka = plaka; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0 || !Double.isFinite(price)) throw new IllegalArgumentException("Price geçersiz.");
        this.price = price;
    }

    public double getYakitTuketimi() { return yakitTuketimi; }
    public void setYakitTuketimi(double yakitTuketimi) {
        if (yakitTuketimi < 0 || !Double.isFinite(yakitTuketimi)) throw new IllegalArgumentException("YakitTuketimi geçersiz.");
        this.yakitTuketimi = yakitTuketimi;
    }

    public Suruculer getSurucu() { return surucu; }
    public void setSurucu(Suruculer surucu) {
        if (surucu == null) throw new IllegalArgumentException("Sürücü boş olamaz.");
        this.surucu = surucu;
    }

    public void aracBilgileriniGoster() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
    }

    public void start() {
        System.out.println("calisiyor");
    }
}
