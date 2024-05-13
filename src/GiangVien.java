import java.util.Objects;

public class GiangVien extends NhanVien {
    private String monGiangDay;
    private double thuLaoGiangDay;

    public GiangVien(String ten, int tuoi, String diaChi, String maNV, PhongBanKhoa phongBan, String monGiangDay ,double thuLaoGiangDay) {
        super(ten, tuoi, diaChi, maNV, phongBan, thuLaoGiangDay);
        this.monGiangDay = monGiangDay;
        this.thuLaoGiangDay = thuLaoGiangDay;

    }

    public String getMonGiangDay() {
        return monGiangDay;
    }

    public void setMonGiangDay(String monGiangDay) {
        this.monGiangDay = monGiangDay;
    }

    public double getThuLaoGiangDay() {
        return thuLaoGiangDay;
    }

    public void setThuLaoGiangDay(double thuLaoGiangDay) {
        this.thuLaoGiangDay = thuLaoGiangDay;
    }

    public double tinhLuong() {

        return luongCoban * thuLaoGiangDay;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "monGiangDay='" + monGiangDay + '\'' +
                ", maNV='" + maNV + '\'' +
                ", phongBan=" + phongBan +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                ", thuLaoGiangDay='" + thuLaoGiangDay + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        GiangVien giangVien = (GiangVien) o;
        return Objects.equals(monGiangDay, giangVien.monGiangDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monGiangDay);
    }
}
