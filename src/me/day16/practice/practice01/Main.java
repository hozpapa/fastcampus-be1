package me.day16.practice.practice01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            inputMoney();

        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    // 예외 전환 코드
    public static int inputMoney() throws InputMismatchException {
        int money = scanner.nextInt();

        if (money < 0) {
            try {
                throw new InputNegativeException("Money can't less than 0");
            } catch (InputNegativeException e) {
                throw new InputMismatchException(e.getMessage());
            }
        }
        return money;
    }
}
