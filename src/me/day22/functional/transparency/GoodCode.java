package me.day22.functional.transparency;

public class GoodCode {
    public int add() {
        return 3 + 5;
    }
    public static void main(String[] args) {
        new GoodCode().add(); // 8
        new GoodCode().add(); // 8

        // ....

        new GoodCode().add(); // 8
    }
}
