package me.day06.function;

public class VarsArgExample {
    public static void main(String[] args) {
        sum();
        sum(1);
        sum(1, 2);
        sum(1, 2, 3);
        sum(1, 2, 3, 4, 5, 6);
    }
    public static int sum(int... vars) { // 가변 인자, int[] vars
        int sum = 0;
        for (int v: vars) {
            sum += v;
        }
        return sum;
    }
}
