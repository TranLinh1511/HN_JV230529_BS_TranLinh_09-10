package bai2;


import config.InputMethods;

import java.util.Scanner;
import java.util.Stack;

public class Exam_Advance_2 {
    public  static  Stack<String> wordStack = new Stack<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            int choose = InputMethods.getInteger();
            switch (choose) {
                case 1:
                    System.out.print("Nhập câu: ");
                    String sentence = sc.nextLine();
                    String[] words = sentence.split(" ");
                    for (String word : words) {
                        wordStack.push(word);
                    }
                    System.out.println("Câu đã được nhập.");
                    break;
                case 2:
                    System.out.print("Câu đảo ngược: ");
                    while (!wordStack.isEmpty()) {
                        System.out.print(wordStack.pop() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    return;
            }
        } while (true);

    }
}
