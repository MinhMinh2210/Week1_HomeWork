import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ArrayList<SinhVien> danhSachSinhVien;
    private ArrayList<NhanVienQuanLy> danhSachNhanVienQuanLy;
    private ArrayList<GiangVien> danhSachGiangVien;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.danhSachSinhVien = new ArrayList<>();
        this.danhSachNhanVienQuanLy = new ArrayList<>();
        this.danhSachGiangVien = new ArrayList<>();
    }

    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Nhập thông tin Sinh Viên");
            System.out.println("2. Nhập thông tin Nhân Viên Quản Lý");
            System.out.println("3. Nhập thông tin Giảng Viên");
            System.out.println("4. Xuất danh sách Sinh Viên");
            System.out.println("5. Xuất danh sách Nhân Viên Quản Lý");
            System.out.println("6. Xuất danh sách Giảng Viên");
            System.out.println("7. Xuất danh sách Nhân Viên - Giảng Viên");
            System.out.println("8. Xuất tất cả danh sách");
            System.out.println("9. Tìm nhân viên có hệ số lương cao nhất");
            System.out.println("10. Tìm nhân viên theo tên");
            System.out.println("11. Tìm sinh viên theo loại");
            System.out.println("12. Thoát");
            System.out.print("Nhập lựa chọn của bạn (1-11): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    enterInfo("Sinh Viên");
                    break;
                case 2:
                    enterInfo("Nhân Viên Quản Lý");
                    break;
                case 3:
                    enterInfo("Giảng Viên");
                    break;
                case 4:
                    System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
                    displayStudents();
                    break;
                case 5:
                    System.out.println("\n=== DANH SÁCH NHÂN VIÊN QUẢN LÝ ===");
                    displayManagers();
                    break;
                case 6:
                    System.out.println("\n=== DANH SÁCH GIẢNG VIÊN ===");
                    displayLecturers();
                    break;
                case 7:
                    System.out.println("XUẤT DANH SÁCH NHÂN VIÊN - GIẢNG VIÊN");
                    displayAllManagers();
                    break;
                case 8:
                    System.out.println("XUẤT TẤT CẢ DANH SÁCH");
                   displayAllLists();
                    break;
                case 9:
                    System.out.println("DANH SÁCH NHÂN VIÊN CÓ HỆ SỐ LƯƠNG CAO NHẤT");
                    displayHighestPaidEmployee();
                    break;
                case 10:
                    System.out.println("TÌM NHÂN VIÊN THEO TÊN");
                    searchEmployeeByName();
                    break;
                case 11:
                    displayStudentsByGrade();
                    break;

                case 12:
                    System.out.println("Đang thoát chương trình...");
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        }
        scanner.close();
    }

    private void enterInfo(String type) {
        System.out.print("Nhập số lượng " + type + " muốn thêm vào danh sách: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (type) {
            case "Sinh Viên":
                enterStudents(count);
                break;
            case "Nhân Viên Quản Lý":
                enterManagers(count);
                break;
            case "Giảng Viên":
                enterLecturers(count);
                break;
            default:
                System.out.println("Loại không hợp lệ!");
        }
    }

    private void enterStudents(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho Sinh Viên thứ " + (i + 1) + ":");
            enterStudentInfo();
        }
    }

    private void enterManagers(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho Nhân Viên Quản Lý thứ " + (i + 1) + ":");
            enterManagerInfo();
        }
    }

    private void enterLecturers(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho Giảng Viên thứ " + (i + 1) + ":");
            enterLecturerInfo();
        }
    }

    private void enterStudentInfo() {
        System.out.print("Nhập tên sinh viên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Nhập địa chỉ sinh viên: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập mã sinh viên: ");
        String maSV = scanner.nextLine();
        System.out.print("Nhập chuyên ngành: ");
        String chuyenNganh = scanner.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        double diemTrungBinh = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over

        // Determine the grade based on the GPA
        String xepLoai;
        if (diemTrungBinh >= 9.0) {
            xepLoai = "Xuất sắc";
        } else if (diemTrungBinh >= 8.0) {
            xepLoai = "Giỏi";
        } else if (diemTrungBinh >= 7.0) {
            xepLoai = "Khá";
        } else if (diemTrungBinh >= 6.0) {
            xepLoai = "Trung bình khá";
        } else if (diemTrungBinh >= 5.0) {
            xepLoai = "Trung bình";
        } else {
            xepLoai = "Yếu";
        }

        SinhVien sinhVien = new SinhVien(ten, tuoi, diaChi, maSV, chuyenNganh, diemTrungBinh, xepLoai);
        danhSachSinhVien.add(sinhVien);
        System.out.println("Đã nhập thông tin sinh viên:");
        System.out.println(sinhVien);
    }


    private void enterManagerInfo() {
        Scanner scanner = new Scanner(System.in); // Đảm bảo đã khai báo và khởi tạo đối tượng Scanner

        System.out.print("Nhập tên nhân viên quản lý: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập tuổi nhân viên quản lý: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập địa chỉ nhân viên quản lý: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String maNV = scanner.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        String tenPhongBan = scanner.nextLine();
        System.out.print("Nhập mã phòng ban: ");
        String maPhongBan = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        double heSoLuong = Double.parseDouble(scanner.nextLine());

        PhongBanKhoa phongBan = new PhongBanKhoa(tenPhongBan, maPhongBan);
        NhanVienQuanLy nhanVienQuanLy = new NhanVienQuanLy(ten, tuoi, diaChi, maNV, phongBan, heSoLuong);
        danhSachNhanVienQuanLy.add(nhanVienQuanLy); // Đảm bảo danhSachNhanVienQuanLy đã được khai báo và khởi tạo

        System.out.println("Đã nhập thông tin nhân viên quản lý:");
        System.out.println(nhanVienQuanLy);

        // Hiển thị lương đã tính
        double luong = nhanVienQuanLy.tinhLuong();
        System.out.printf("Lương của nhân viên quản lý %s (Mã NV: %s) là: %.2f VND\n", ten, maNV, luong);
    }


    private void enterLecturerInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên giảng viên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập tuổi giảng viên: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.print("Nhập địa chỉ giảng viên: ");
        String diaChi = scanner.nextLine();
        System.out.print("Nhập mã nhân viên: ");
        String maNV = scanner.nextLine();
        System.out.print("Nhập môn giảng dạy: ");
        String monGiangDay = scanner.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        String tenPhongBan = scanner.nextLine();
        System.out.print("Nhập mã phòng ban: ");
        String maPhongBan = scanner.nextLine();
        System.out.print("Nhập hệ số lương: ");
        double thuLaoGiangDay = Double.parseDouble(scanner.nextLine());

        // Tạo đối tượng phòng ban
        PhongBanKhoa phongBan = new PhongBanKhoa(tenPhongBan, maPhongBan);
        GiangVien giangVien = new GiangVien(ten, tuoi, diaChi, maNV, phongBan, monGiangDay, thuLaoGiangDay);
        danhSachGiangVien.add(giangVien);
        System.out.println("Đã nhập thông tin giảng viên:");
        System.out.println(giangVien);
        double luong = giangVien.tinhLuong();
        System.out.printf("Lương của nhân viên quản lý %s (Mã NV: %s) là: %.2f VND\n", ten, maNV, luong);
    }

    private void displayStudents() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (SinhVien sv : danhSachSinhVien) {
                System.out.println(sv);
            }
        }
    }

    private void displayManagers() {
        if (danhSachNhanVienQuanLy.isEmpty()) {
            System.out.println("Danh sách nhân viên quản lý trống.");
        } else {
            System.out.println("Danh sách nhân viên quản lý:");
            for (NhanVienQuanLy nvql : danhSachNhanVienQuanLy) {
                System.out.println(nvql);
            }
        }
    }

    private void displayLecturers() {
        if (danhSachGiangVien.isEmpty()) {
            System.out.println("Danh sách giảng viên trống.");
        } else {
            System.out.println("Danh sách giảng viên:");
            for (GiangVien gv : danhSachGiangVien) {
                System.out.println(gv);
            }
        }
    }

    public void displayAllLists() {
        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        displayStudents();
        System.out.println("\n=== DANH SÁCH NHÂN VIÊN QUẢN LÝ ===");
        displayManagers();
        System.out.println("\n=== DANH SÁCH GIẢNG VIÊN ===");
        displayLecturers();
    }

    public void displayAllManagers() {
        System.out.println("\n=== DANH SÁCH NHÂN VIÊN QUẢN LÝ ===");
        displayManagers();
        System.out.println("\n=== DANH SÁCH GIẢNG VIÊN ===");
        displayLecturers();
    }

    private NhanVien findHighestPaidEmployee() {
        if (danhSachNhanVienQuanLy.isEmpty() && danhSachGiangVien.isEmpty()) {
            return null;
        }

        NhanVien highestPaidEmployee = null;
        double maxSalary = Double.MIN_VALUE;

        for (NhanVienQuanLy manager : danhSachNhanVienQuanLy) {
            double salary = manager.tinhLuong();
            if (salary > maxSalary) {
                highestPaidEmployee = manager;
                maxSalary = salary;
            }
        }

        for (GiangVien lecturer : danhSachGiangVien) {
            double salary = lecturer.tinhLuong();
            if (salary > maxSalary) {
                highestPaidEmployee = lecturer;
                maxSalary = salary;
            }
        }

        return highestPaidEmployee;
    }


    public void displayHighestPaidEmployee() {
        NhanVien highestPaidEmployee = findHighestPaidEmployee();
        if (highestPaidEmployee == null) {
            System.out.println("Không có nhân viên nào trong danh sách.");
        } else {
            System.out.println("\n=== NHÂN VIÊN CÓ MỨC LƯƠNG CAO NHẤT ===");
            System.out.println(highestPaidEmployee);
            if (highestPaidEmployee instanceof NhanVienQuanLy) {
                System.out.printf("Mức lương: %.2f VND\n", ((NhanVienQuanLy) highestPaidEmployee).tinhLuong());
            } else if (highestPaidEmployee instanceof GiangVien) {
                System.out.printf("Mức lương: %.2f VND\n", ((GiangVien) highestPaidEmployee).tinhLuong());
            } else {
                System.out.println("Không thể tính toán mức lương cho nhân viên này.");
            }
        }
    }

    private void searchEmployeeByName() {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (NhanVienQuanLy manager : danhSachNhanVienQuanLy) {
            if (manager.getTen().equalsIgnoreCase(name)) {
                System.out.println("Nhân viên quản lý:");
                System.out.println(manager);
                found = true;
                break;
            }
        }

        for (GiangVien lecturer : danhSachGiangVien) {
            if (lecturer.getTen().equalsIgnoreCase(name)) {
                System.out.println("Giảng viên:");
                System.out.println(lecturer);
                found = true;
                break;
            }
        }

        for (SinhVien student : danhSachSinhVien) {
            if (student.getTen().equalsIgnoreCase(name)) {
                System.out.println("Sinh viên:");
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy nhân viên có tên là " + name);
        }
    }

    private void displayStudentsByGrade() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
            System.out.print("Nhập xếp loại sinh viên muốn hiển thị (Yêu cầu nhập đúng định dạng: Xuất sắc, Giỏi, Khá, Trung bình, Yếu): ");
            String grade = scanner.nextLine();

            boolean found = false;
            System.out.println("Danh sách sinh viên loại " + grade + ":");
            for (SinhVien sv : danhSachSinhVien) {
                if (sv.getXepLoai().equalsIgnoreCase(grade)) {
                    System.out.println(sv);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không có sinh viên nào thuộc loại " + grade);
            }
        }
    }
}
