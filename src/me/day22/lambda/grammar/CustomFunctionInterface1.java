package me.day22.lambda.grammar;

@FunctionalInterface
public interface CustomFunctionInterface1 {
    void lambda();
//    void lambda2();

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
