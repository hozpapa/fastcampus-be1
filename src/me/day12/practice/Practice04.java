package me.day12.practice;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        StringBuilder leftBuilder = new StringBuilder(strings[0]).reverse();
        StringBuilder rightBuilder = new StringBuilder(strings[1]).reverse();
        String max = leftBuilder.compareTo(rightBuilder) < 0 ?
                rightBuilder.toString() : leftBuilder.toString();
        System.out.println(max);
    }
}
