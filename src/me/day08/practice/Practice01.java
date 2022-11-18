package me.day08.practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input);
        String string1 = new StringBuilder(stringTokenizer.nextToken()).reverse().toString();
        String string2 = new StringBuilder(stringTokenizer.nextToken()).reverse().toString();

        String answer = string1.compareTo(string2) > 0 ? string1 : string2;
        System.out.println(answer);

        scanner.close();
    }
}
