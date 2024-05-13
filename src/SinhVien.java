import java.util.Objects;

public class SinhVien extends ConNguoi {
    private String maSV;
    private String chuyenNganh;
    private double diemTrungBinh;
    private String xepLoai;


    public SinhVien(String ten, int tuoi, String diaChi, String maSV, String chuyenNganh , double diemTrungBinh, String xepLoai) {
        super(ten, tuoi, diaChi);
        this.maSV = maSV;
        this.chuyenNganh = chuyenNganh;
        this.diemTrungBinh = diemTrungBinh;
        this.xepLoai = xepLoai;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }



    @Override
    public String toString() {
        return "SinhVien{" +
                "Mã sô sinh viên='" + maSV + '\'' +
                ", chuyên ngành='" + chuyenNganh + '\'' +
                ", tên='" + ten + '\'' +
                ", tuổi=" + tuoi +
                ", địa chỉ='" + diaChi + '\'' +
                ", điểm trung bình='" + diemTrungBinh + '\'' +
                ", xếp loại='" + xepLoai + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(maSV, sinhVien.maSV) &&
                Objects.equals(chuyenNganh, sinhVien.chuyenNganh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maSV, chuyenNganh);
    }
}
