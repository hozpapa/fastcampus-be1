package me.day07.practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("메시지 입력: ");
        String message = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(message);
        StringBuilder totalBuilder = new StringBuilder();

        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Character.toString(word.charAt(0)).toLowerCase());
            stringBuilder.append(word.substring(1).toUpperCase());

            totalBuilder.append(stringBuilder);
            totalBuilder.append(" ");
        }
        String encodeMessage = totalBuilder.toString().strip();
        System.out.println(encodeMessage);

        scanner.close();
    }
}
