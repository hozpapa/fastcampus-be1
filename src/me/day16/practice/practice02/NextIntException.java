package me.day16.practice.practice02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextIntException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // 예외 복구 코드
        int number = 0;
        while (true) {
            try {
                System.out.print(">> input number : ");
                number = scanner.nextInt(); // 문자열 입력할 경우
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // 버퍼를 지움
                e.printStackTrace();
            }
        }
        System.out.println("number = " + number);

        scanner.close();
    }
}