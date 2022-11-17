package me.day05.breaks;

import java.util.Scanner;

public class BreakContinueExample {
    public static void main(String[] args) {
//        while (true) {} (**)
//        for(;;)
        Scanner scanner = new Scanner(System.in);

        // 1 ~ 10까지 도는 반복문에서 3의 배수가 나오면 종료
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) break; // 3
            System.out.println("i = " + i);
        }
        System.out.println("out of for .... ");


        for (int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);
//            if (i % 3 == 0) continue; // 의미가 없는 continue 문장
        }
        System.out.println("out of for .... ");

        // 사용자한테 문자 하나를 계속 입력받다가 q 가 나오면 종료
        // 입력받은 문자들을 문자열 합치는 방법 ('a', 'b', 'c', 'q') => "abc"
        // 입력받은 문자들을 문자열 합치는 방법 ('a', 'b', 'c', 'q') => "cba"
        // StringBuilder, StringBuffer, reverse() 함수 사용 불가!
        
        String str = "";
        while (true) {
            char ch = scanner.next().charAt(0);
            if (ch == 'q') break;
            str = ch + str;
            // str = str + ch
            System.out.println("str = " + str);
        }

        scanner.close();
    }
}
