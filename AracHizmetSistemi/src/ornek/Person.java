package ornek;


public abstract class Person {

    private String name;
    private int age;
    private String gender;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("İsim boş olamaz.");
        setName(name);
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Yaş negatif olamaz.");
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String toString() {
        return "Name: " + name + " | Age: " + age;
    }

    public abstract void bilgileriGoster();

    public abstract void performJob();
}