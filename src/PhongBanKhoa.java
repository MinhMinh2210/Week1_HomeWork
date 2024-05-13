import java.util.Objects;

public class PhongBanKhoa {
    private String tenKhoa;
    private String maKhoa;

    public PhongBanKhoa(String tenKhoa, String maKhoa) {
        this.tenKhoa = tenKhoa;
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public String toString() {
        return "PhongBanKhoa{" +
                "tenKhoa='" + tenKhoa + '\'' +
                ", maKhoa='" + maKhoa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongBanKhoa that = (PhongBanKhoa) o;
        return Objects.equals(tenKhoa, that.tenKhoa) &&
                Objects.equals(maKhoa, that.maKhoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenKhoa, maKhoa);
    }
}
