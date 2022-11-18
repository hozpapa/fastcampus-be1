package me.day10.constructor;

public class Main {
    public static void main(String[] args) {
        ConstructorNotGoodCode c1 = new ConstructorNotGoodCode();
        System.out.println(c1);

        A a = new A();
        B b = new B();
        System.out.println(a);
        System.out.println(b);
        ConstructorNotGoodCode c2 = new ConstructorNotGoodCode(a, b);
        System.out.println(c2);
    }
}
