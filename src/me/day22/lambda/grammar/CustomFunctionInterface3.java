package me.day22.lambda.grammar;

@FunctionalInterface
public interface CustomFunctionInterface3<T> {
    void lambda(T... args);
//    void lambda2(T... args);

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
