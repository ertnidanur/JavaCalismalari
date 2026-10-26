import java.time.LocalDate;

class OduncKaydi {
    private final int kitapId;
    private final int uyeId;
    private final LocalDate alisTarihi;
    private final LocalDate sonTeslimTarihi;

    public OduncKaydi(int kitapId, int uyeId,
                      LocalDate alisTarihi, int oduncGunSayisi) {
        this.kitapId = kitapId;
        this.uyeId = uyeId;
        this.alisTarihi = alisTarihi;
        this.sonTeslimTarihi = alisTarihi.plusDays(oduncGunSayisi);
    }

    public int getKitapId() {
        return kitapId;
    }

    public int getUyeId() {
        return uyeId;
    }

    public LocalDate getAlisTarihi() {
        return alisTarihi;
    }

    public LocalDate getSonTeslimTarihi() {
        return sonTeslimTarihi;
    }

    public boolean geciktiMi() {
        return LocalDate.now().isAfter(sonTeslimTarihi);
    }
}