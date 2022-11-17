package me.day06.arrays2d;

import java.util.Scanner;

public class Arrays2dExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ROW = 5; // 학생 수
        final int COL = 3; // 과목 수

        // 행: 학생 번호
        // 열: 과목 번호
        int[][] scores1 = new int[ROW][COL]; // 배열의 크기만 알고 있는 경우 (나중에 데이터를 초기화)
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(scores1[i][j] + " ");
            }
            System.out.println();
        }


        int[][] scores2 = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}, {10, 20, 30}, {40, 50, 60}};
        // 배열 선언시 데이터를 알고 있는 경우 (한줄 초기화)
        
        int[][] scores3;
        scores3 = new int[][] {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}, {10, 20, 30}, {40, 50, 60}}; 
        // 배열 선언시 데이터를 알고 있는 경우 (두줄로 작성 가능)
        
        // 이차원 배열의 원소 입력
        // 1번 학생의 성적을 입력하시오: (i)
        // 국어성적: (j)
        // 수학성적: (j)
        // 영어성적: (j)
        String[] subjects = {"국어", "수학", "영어"};
        for (int i = 0; i < ROW; i++) { // 행의 길이 (5)
            System.out.printf("%d번 학생의 성적을 입력하시오\n", i+1);
            for (int j = 0; j < COL ; j++) { // 열의 길이 (3) (scores[i].length == scores[0].length)
                System.out.printf("%s 성적: ", subjects[j]);
                scores1[i][j] = scanner.nextInt();
            }
        }
        System.out.println();

        // 이차원 배열의 원소 출력
        for (int i = 0; i < ROW; i++) { // 행의 길이 (5)
            System.out.printf("%d번 학생 성적입니다\n", i+1);
            for (int j = 0; j < COL ; j++) { // 열의 길이 (3) (scores[i].length == scores[0].length)
                System.out.printf("%s 성적: %d\n", subjects[j], scores1[i][j]);
            }
        }
        System.out.println();

        // 각 학생들의 과목 평균
        double[] averages = new double[ROW];

        for (int i = 0; i < ROW; i++) { // 행의 길이 (5)
            int sum = 0; // 각 학생들의 성적 합계
            for (int j = 0; j < COL ; j++) { // 열의 길이 (3) (scores[i].length == scores[0].length)
                sum += scores1[i][j];
            }
            averages[i] = sum / (double) COL;
        }

        for (int i = 0; i < averages.length; i++) {
            System.out.printf("%d번 학생의 평균: %f\n", i+1, averages[i]);
        }

        scanner.close();
    }
}
