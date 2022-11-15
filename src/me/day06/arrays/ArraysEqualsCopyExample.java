package me.day06.arrays;

import java.util.Arrays;

public class ArraysEqualsCopyExample {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2) + "\n");

        System.out.println(isEquals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr2) + "\n");

        int[] copy = copy(arr1);
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1) + "\n");
        System.out.println(copy);
        System.out.println(Arrays.toString(copy));
    }

    // 두 배열이 모두 동일한 원소를 가지고 있는지 확인하는 함수
    public static boolean isEquals(int[] arr1, int[] arr2) {
        // 예외처리
        if (arr1.length != arr2.length) return false; // early-return

        // arr1.length == arr2.length
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        // 모든 배열 구성 원소 값이 동일함
        return true;
    }

    // 하나의 배열의 원소를 복사하는 함수
    public static int[] copy(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
