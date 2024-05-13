import java.util.Objects;


public class ConNguoi {
    protected String ten;
    protected int tuoi;
    protected String diaChi;

    public ConNguoi(String ten, int tuoi, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "ConNguoi{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConNguoi conNguoi = (ConNguoi) o;
        return tuoi == conNguoi.tuoi &&
                Objects.equals(ten, conNguoi.ten) &&
                Objects.equals(diaChi, conNguoi.diaChi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tuoi, diaChi);
    }
}
