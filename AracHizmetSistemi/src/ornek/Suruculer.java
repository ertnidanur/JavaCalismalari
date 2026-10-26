package ornek;

public class Suruculer extends Person {

    private int id;
    private boolean musaitMi;

    public Suruculer(String name, int age) {
        super(name, age);
        this.musaitMi = true;
    }

    @Override
    public void setAge(int age) {
        if (age < 18)
            throw new IllegalArgumentException("Sürücü 18 yaşından küçük olamaz.");
        super.setAge(age);
    }

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

    public void addSurucu() {
        System.out.println("Surucu eklendi.");
    }

    public void setMusaitMi(boolean musaitMi) {
        this.musaitMi = musaitMi;
    }
    public boolean getMusaitMi() {
        return musaitMi;
    }

    double puanGetir(double puan) {
        return puan;
    }

    @Override
    public void performJob() {
        System.out.println("This is a Driver");
    }
}
