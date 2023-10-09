package bai3;

import config.InputMethods;

import java.util.LinkedList;
import java.util.Queue;

public class Exam_Advance_3 {
   public static Queue<String> parent = new LinkedList<>();
    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choose = InputMethods.getInteger();
            switch (choose) {
                case 1:
                    System.out.print("Nhập tên phụ huynh: ");
                    String parentName = InputMethods.getString();
                    parent.add(parentName);
                    break;
                case 2:
                    if (parent.isEmpty()) {
                        System.out.println("Danh sách phụ huynh rỗng!!");
                    } else {
                        String phuHuynhDauTien = parent.poll();
                        System.out.println("Phụ huynh đầu tiên là: " + phuHuynhDauTien);
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    return;
                default:
                    System.out.println("Yêu cầu nhập đúng trường!!");
            }
        }while (true);
    }
}
