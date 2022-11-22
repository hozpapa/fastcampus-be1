package me.day12.practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(sentence); // 빈 문자열은 토큰이 아님
        System.out.println(stringTokenizer.countTokens());

//        String[] strings = sentence.split(" "); // 빈 문자열도 토큰
//        System.out.println(strings.length);

        scanner.close();
    }
}
