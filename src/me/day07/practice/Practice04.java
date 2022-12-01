package me.day07.practice;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        StringBuilder leftBuilder = new StringBuilder(strings[0]).reverse();
        StringBuilder rightBuilder = new StringBuilder(strings[1]).reverse();
        StringBuilder max = leftBuilder.compareTo(rightBuilder) < 0 ? rightBuilder : leftBuilder;
        System.out.println(max);

        scanner.close();
    }
}
