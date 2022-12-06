package me.day22.lambda.methodreference.staticInstance;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        // static method reference
        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println(operator.applyAsInt(1, 2));

        operator = Calculator :: staticMethod;
        System.out.println(operator.applyAsInt(1, 2));


        // instance method reference
        Calculator calculator = new Calculator();
        operator = (x, y) -> calculator.instanceMethod(x, y);
        System.out.println(operator.applyAsInt(1, 2));

        operator = calculator :: instanceMethod;
        System.out.println(operator.applyAsInt(1, 2));

    }
}
