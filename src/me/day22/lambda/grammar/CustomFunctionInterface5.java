package me.day22.lambda.grammar;

@FunctionalInterface
public interface CustomFunctionInterface5<T> {
    T lambda(T... args);
//    T lambda2(T... args);

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
