package me.day05.practice;

public class Practice04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                System.out.printf("(%d, %d)\n", i, j);
            }
        }
    }
}
