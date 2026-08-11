package com.mycompany.quanlysinhvien;

import java.util.Scanner;

public class App {

    // Hàm nhập điểm và kiểm tra hợp lệ
    public static double nhapDiem(Scanner sc, String tenDiem) {

        double diem;

        while (true) {

            System.out.println("Nhập " + tenDiem + ":");

            // Kiểm tra người dùng có nhập số hay không
            if (!sc.hasNextDouble()) {

                System.out.println("Lỗi: Vui lòng nhập một số!");

                sc.next();

                continue;
            }

            diem = sc.nextDouble();

            // Kiểm tra điểm từ 0 đến 10
            if (diem >= 0 && diem <= 10) {
                return diem;
            }

            System.out.println(
                    "Lỗi: Điểm phải nằm trong khoảng 0 đến 10!"
            );

            System.out.println("Vui lòng nhập lại.");
        }
    }

    // Hàm xếp loại
    public static String xepLoai(double diemTongKet) {

        if (diemTongKet >= 8.5) {
            return "A";

        } else if (diemTongKet >= 7.0) {
            return "B";

        } else if (diemTongKet >= 5.5) {
            return "C";

        } else if (diemTongKet >= 4.0) {
            return "D";

        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ==============================
        // NHẬP DỮ LIỆU
        // ==============================

        System.out.println("========================================");
        System.out.println("       NHẬP THÔNG TIN SINH VIÊN");
        System.out.println("========================================");

        System.out.println("Nhập mã sinh viên:");
        String maSV = sc.nextLine();

        System.out.println("Nhập họ tên:");
        String hoTen = sc.nextLine();

        double chuyenCan = nhapDiem(
                sc,
                "điểm chuyên cần"
        );

        double giuaKy = nhapDiem(
                sc,
                "điểm giữa kỳ"
        );

        double cuoiKy = nhapDiem(
                sc,
                "điểm cuối kỳ"
        );

        // ==============================
        // TÍNH ĐIỂM TỔNG KẾT
        // ==============================

        double diemTongKet =
                chuyenCan * 0.10
                + giuaKy * 0.30
                + cuoiKy * 0.60;

        // ==============================
        // XẾP LOẠI
        // ==============================

        String loai = xepLoai(diemTongKet);

        // ==============================
        // HIỂN THỊ KẾT QUẢ
        // ==============================

        System.out.println();

        System.out.println("========================================");
        System.out.println("          THÔNG TIN SINH VIÊN");
        System.out.println("========================================");

        System.out.println("Mã sinh viên:");
        System.out.println(maSV);

        System.out.println("Họ tên:");
        System.out.println(hoTen);

        System.out.println("Điểm chuyên cần:");
        System.out.printf("%.2f%n", chuyenCan);

        System.out.println("Điểm giữa kỳ:");
        System.out.printf("%.2f%n", giuaKy);

        System.out.println("Điểm cuối kỳ:");
        System.out.printf("%.2f%n", cuoiKy);

        System.out.println("----------------------------------------");

        System.out.println("Điểm tổng kết:");
        System.out.printf("%.2f%n", diemTongKet);

        System.out.println("Xếp loại:");
        System.out.println(loai);

        System.out.println("========================================");

        sc.close();
    }
}