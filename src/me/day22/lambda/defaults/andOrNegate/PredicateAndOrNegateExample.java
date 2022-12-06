package me.day22.lambda.defaults.andOrNegate;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample {
    public static void main(String[] args) {
        // 2의 배수 검사
        IntPredicate predicateA = a -> a % 2 == 0;

        // 3의 배수 검사
        IntPredicate predicateB = a -> a % 3 == 0;


        IntPredicate predicateAB;
        boolean res;

        // and()
        predicateAB = predicateA.and(predicateB);
        res = predicateAB.test(9);
        System.out.println("9는 2와 3의 배수입니까? " + res);

        // or()
        predicateAB = predicateA.or(predicateB);
        res = predicateAB.test(9);
        System.out.println("9는 2 또는 3의 배수입니까? " + res);

        // negate()
        predicateAB = predicateA.negate();
        res = predicateAB.test(9);
        System.out.println("9는 2의 배수가 아닙니까? " + res);
    }
}
