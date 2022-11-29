package me.day02.input;

import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        int age = 0;
        String gender; // 성별
        double height; // 키
        char alphabet; // 알파벳 (nextCharacter() 없음)

        System.out.print("이름 입력: ");
        name = scanner.nextLine(); // 문자열 입력 // Sally Choi\n

        System.out.print("나이 입력: ");
        age = scanner.nextInt(); // 정수 입력

        System.out.print("성별 입력: ");
        gender = scanner.next(); // 문자열 입력

        System.out.print("키 입력: ");
        height = scanner.nextDouble(); // 문자열 입력

        System.out.print("알파벳 입력: ");
        alphabet = scanner.next().charAt(0); // 문자 하나 입력

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("height = " + height);
        System.out.println("alphabet = " + alphabet);

        scanner.close();
    }
}
