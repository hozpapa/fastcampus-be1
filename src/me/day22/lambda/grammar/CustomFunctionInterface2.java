package me.day22.lambda.grammar;

@FunctionalInterface
public interface CustomFunctionInterface2<T> {
    void lambda(T arg);
//    void lambda2(T arg);

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
