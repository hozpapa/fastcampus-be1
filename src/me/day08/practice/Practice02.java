package me.day08.practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 공백도 토큰으로 인식하기 때문에 가장 앞 뒤 공백도 카운팅됨
//        String[] answers = input.split(" ");
//        System.out.println(answers.length);

        // 공백은 토큰으로 인식하지 않기 때문에 때문에 가장 앞 뒤 공백은 카운팅되지 않음
        StringTokenizer stringTokenizer = new StringTokenizer(input);
        System.out.println(stringTokenizer.countTokens());

        scanner.close();;
    }
}
