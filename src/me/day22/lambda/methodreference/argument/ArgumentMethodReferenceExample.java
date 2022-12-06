package me.day22.lambda.methodreference.argument;

import java.util.Objects;
import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferenceExample {
    public static void main(String[] args) {
        // String, String -> Int
        ToIntBiFunction<String, String> function;

        function = (a, b) -> a.compareToIgnoreCase(b);
        print(function.applyAsInt("Java8", "java8"));

        function = String :: compareToIgnoreCase; // a 클래스가 String 이므로
        print(function.applyAsInt("Java8", "java8"));
    }

    public static void print(int order) {
        if (order < 0) System.out.println("사전 순으로 먼저 옴");
        else if (order  == 0) System.out.println("동일한 문자열");
        else System.out.println("사전 순으로 나중에 옴");
    }
}
