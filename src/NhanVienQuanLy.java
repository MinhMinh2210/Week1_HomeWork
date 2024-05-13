public class NhanVienQuanLy extends NhanVien {
    private double heSoLuong;

    public NhanVienQuanLy(String ten, int tuoi, String diaChi, String maNV, PhongBanKhoa phongBan, double heSoLuong) {
        super(ten, tuoi, diaChi, maNV, phongBan, heSoLuong);
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong() {

        return luongCoban + heSoLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    @Override
    public String toString() {
        return "NhanVienQuanLy{" +
                "maNV='" + maNV + '\'' +
                ", phongBan=" + phongBan +
                ", ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                ", heSoLuong=" + heSoLuong +
                '}';
    }
}
