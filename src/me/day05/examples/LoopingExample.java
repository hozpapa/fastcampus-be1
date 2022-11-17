package me.day05.examples;

import java.util.Scanner;

public class LoopingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM = 5;

        ////////////////////// 응용 /////////////////////
        // 사용자에게 입력받은 5개의 정수 평균을 구하는 프로그램
//        double average = 0.0;
//        int sum = 0;
//        for (int i = 0; i < NUM; i++) {
//            System.out.print("input num: ");
//            sum += scanner.nextInt();
//        }
//        average = (double) sum / NUM;
//        System.out.println("average = " + average);
//        System.out.println();

        // 사용자에게 입력받은 5개의 정수 중 가장 최솟값 / 최댓값
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < NUM; i++) {
            System.out.print("input num: ");
            num = scanner.nextInt(); // 10 20 30 40 50 // -10 -20 -30 -40 -50
//            if (i == 0) {
//                min = num;
//                max = num;
//            }

            if (min > num) min = num; // i == 0, min = 10
            if (max < num) max = num; // i == 0, max = -10
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);

        scanner.close();
    }
}
