package me.day22.lambda.grammar;

@FunctionalInterface // only 1 abstract method => lambda target method
public interface CustomFunctionInterface1 {
    void lambda(); // 함수 구현은 모르지만 매개변수가 없고 반환값도 없음
//    void lambda2();

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
    static void staticMethod() {
        System.out.println("staticMethod");
    }
}
