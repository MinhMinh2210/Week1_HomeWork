import java.util.Objects;

public class NhanVien extends ConNguoi {
    protected String maNV;
    protected PhongBanKhoa phongBan;
    protected double luongCoban;

    public NhanVien(String ten, int tuoi, String diaChi, String maNV, PhongBanKhoa phongBan, double luongCoban) {
        super(ten, tuoi, diaChi);
        this.maNV = maNV;
        this.phongBan = phongBan;
        this.luongCoban = 50000000;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public PhongBanKhoa getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBanKhoa phongBan) {
        this.phongBan = phongBan;
    }

    public double getLuongCoban() {
        return luongCoban;
    }

    public void setLuongCoban(double luongCoban) {
        this.luongCoban = luongCoban;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", phongBan=" + phongBan +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        NhanVien nhanVien = (NhanVien) o;
        return Objects.equals(maNV, nhanVien.maNV) &&
                Objects.equals(phongBan, nhanVien.phongBan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maNV, phongBan);
    }
}
