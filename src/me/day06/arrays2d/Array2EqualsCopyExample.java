package me.day06.arrays2d;

import java.util.Arrays;

public class Array2EqualsCopyExample {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 3, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2) + "\n");

        System.out.println("isDeepEquals(arr1, arr2) => " + isDeepEquals(arr1, arr2)); // 사용자 정의 함수
        System.out.println("Arrays.deepEquals(arr1, arr2) => " + Arrays.deepEquals(arr1, arr2) + "\n"); // 자바 클래스
        System.out.println("===============================================\n");


        System.out.println("** Shallow Copy **");
        int[][] original1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] shallowCopy = new int[original1.length][original1[0].length];
        for (int i = 0; i < shallowCopy.length; i++) {
            shallowCopy[i] = original1[i];
            System.out.println("shallowCopy[i] => " + shallowCopy[i]);
            System.out.println("original1[i] => " + original1[i] + "\n");
        }
        System.out.println(original1);
        System.out.println(Arrays.deepToString(original1) + "\n");
        System.out.println(shallowCopy);
        System.out.println(Arrays.deepToString(shallowCopy) + "\n");

        System.out.println(">>> 값 변경");
        shallowCopy[0][0] = 10;
        System.out.println(Arrays.deepToString(original1));
        System.out.println(Arrays.deepToString(shallowCopy) + "\n\n");
        System.out.println("===============================================\n");

        System.out.println("** Deep Copy **");
        int[][] original2 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] deepCopy = deepCopy(original2); // 사용자 정의 함수
        System.out.println(original2);
        System.out.println(Arrays.deepToString(original2) + "\n");
        System.out.println(deepCopy);
        System.out.println(Arrays.deepToString(deepCopy) + "\n");

        System.out.println(">>> 값 변경");
        deepCopy[0][0] = 10;
        System.out.println(Arrays.deepToString(original2));
        System.out.println(Arrays.deepToString(deepCopy) + "\n\n");
    }

    // 두 이차원 배열이 내용물이 같은지 확인하는 함수
    public static boolean isDeepEquals(int[][] arr1, int[][] arr2) {
        // 예외처리
        if (arr1.length != arr2.length) return false;
        if (arr1[0].length != arr2[0].length) return false;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
            }
        }
        return true;
    }

    // 이차원 배열을 복사하는 함수
    public static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

}
