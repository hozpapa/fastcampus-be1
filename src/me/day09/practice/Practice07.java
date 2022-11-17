package me.day09.practice;

import java.util.Scanner;

public class Practice07 {
    static Scanner scanner = new Scanner(System.in);
    static final String END_STRING = "종료";
    static final int END_NUMBER = 5;
    public static void main(String[] args) {

        String[] menus = {"김밥", "라면", "떡볶이", "돈까스"};
        int[] prices = {2500, 3000, 4000, 5000};
        int minPrice = min(prices);

        System.out.print("현금을 얼마 가지고 있니 ? ");
        int money = scanner.nextInt();
        if (money < minPrice) {
            System.out.println("돈이 부족하여 김밥천국 입장 불가능합니다.");
            return;
        }

        // 입장 가능한 사람들
        while (true) {
            int choice = choiceMenu(menus, prices);
            if (choice == END_NUMBER) {
                System.out.println("프로그램 종료.");
                break;
            }
            if (prices[choice-1] <= money) {
                System.out.println(menus[choice-1] + "를 선택하셨습니다.");
                money -= prices[choice-1];
                System.out.println("잔돈은 " + money + "원 입니다.");
            } else {
                System.out.println("돈이 부족하여 메뉴를 선택할 수 없습니다.");
            }

            if (money < minPrice) {
                System.out.println("더이상 선택할 수 없습니다. 프로그램 종료.");
                System.out.println("지금까지 선택하신 식사 주문이 완료되었습니다.");
                break;
            }
        }

        scanner.close();
    }
    public static int min(int[] prices) {
        int min = prices[0]; // 첫번째 값이 최솟값이라고 가정
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) min = prices[i];
        }
        return min;
    }

    public static void printMenu(String[] menus, int[] prices) {
        System.out.println("==================================");
        int i = 0;
        for (i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s - %d\n", i + 1, menus[i], prices[i]);
        }
        System.out.printf("%d. %s\n", END_NUMBER, END_STRING);
        System.out.println("==================================");
    }
    public static int choiceMenu(String[] menus, int[] prices) {
        while(true) {
            printMenu(menus, prices);
            System.out.print("메뉴 주문 번호 => ");
            int choice = scanner.nextInt();
            if (!(choice >= 1 && choice <= menus.length + 1)) {
                System.out.printf("메뉴 선택 오류. 1 ~ %d번 사이의 메뉴를 선택해주세요.\n", menus.length + 1);
                continue;
            }

            return choice;
        }
    }
}
