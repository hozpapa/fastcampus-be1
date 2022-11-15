package me.day06.arrays2d;

import java.util.Arrays;

public class Array2dToArray1dExample {
    public static void main(String[] args) {
        final int ROW = 3;
        final int COL = 3;

        int[][] arr2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] arr1d = new int[ROW * COL]; // {1, 2, 3, 4, 5, 6, 7, 8, 9}

        System.out.println();
        System.out.println("** 2d Array -> 1d Array **");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                arr1d[i * COL + j] = arr2d[i][j];
                // 0, 0 => 0번째 행에 대한 첫 위치 (i * COL) + j
                // 1, 0 => 1번째 행에 대한 첫 위치 (i * COL) + j
                // 2, 0 => 2번째 행에 대한 첫 위치 (i * COL) + j
            }
        }
        System.out.println(Arrays.deepToString(arr2d));
        System.out.println(Arrays.toString(arr1d));
        System.out.println();

        int[] arr1d2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] arr2d2 = new int[ROW][COL];

        System.out.println("** 1d Array -> 2d Array **");
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                arr2d2[i][j] = arr1d2[i * COL + j];
                // 0, 0 => 0번째 행에 대한 첫 위치 (i * COL) + j
                // 1, 0 => 1번째 행에 대한 첫 위치 (i * COL) + j
                // 2, 0 => 2번째 행에 대한 첫 위치 (i * COL) + j
            }
        }
        System.out.println(Arrays.deepToString(arr2d2));
        System.out.println(Arrays.toString(arr1d2));
    }
}
