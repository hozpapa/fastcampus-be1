package me.day22.lambda.operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
    private static int[] ints = { 92, 95, 97, 100, 85, -100, -200, 300 };

    public static int maxOrMin(IntBinaryOperator operator) {
        int res = ints[0];

        for (int i: ints) {
            res = operator.applyAsInt(res, i);
        }
        return res;
    }


    public static void main(String[] args) {
        // max
        int max = maxOrMin(Math :: max);
        System.out.println("max = " + max);

        // min
        int min = maxOrMin(Math :: min);
        System.out.println("min = " + min);

    }
}
