package me.day07.practice;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) { // test case
            int R = scanner.nextInt(); // repeat
            String S = scanner.next(); // string
            StringBuilder P = new StringBuilder();

            for (int i = 0; i < S.length(); i++) {
                for (int r = 0; r < R; r++) {
                    P.append(S.charAt(i));
                }

            }
            System.out.println(P);
        }

        scanner.close();
    }
}
