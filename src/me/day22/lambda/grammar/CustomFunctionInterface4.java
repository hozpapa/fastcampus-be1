package me.day22.lambda.grammar;

@FunctionalInterface
public interface CustomFunctionInterface4 {
    int lambda(int i1, int i2);
//    int lambda2(int i1, int i2);

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
