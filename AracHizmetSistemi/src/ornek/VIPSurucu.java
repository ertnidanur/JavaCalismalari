package ornek;

public final class VIPSurucu extends Suruculer {
	private int vipLevel;   
    private double bonus;
    public VIPSurucu(String name, int age) {
        super(name, age);
    }

    public int getVipLevel() { return vipLevel; }
    public void setVipLevel(int vipLevel) {
        if (vipLevel < 0) throw new IllegalArgumentException("VIP seviyesi negatif olamaz.");
        this.vipLevel = vipLevel;
    }
    public double getBonus() { return bonus; }
    public void setBonus(double bonus) {
        if (!Double.isFinite(bonus) || bonus < 0)
            throw new IllegalArgumentException("Bonus geçersiz.");
        this.bonus = bonus;
    }

    @Override

    public void performJob() {
        System.out.println("This is VIP Driver");
    }
    @Override
    public String toString() {
        return super.toString() 
             + " | VIP Level: " + vipLevel 
             + " | Bonus: " + bonus + " TL";
    }
}
