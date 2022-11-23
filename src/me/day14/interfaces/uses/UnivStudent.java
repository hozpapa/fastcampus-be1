package me.day14.interfaces.uses;

public class UnivStudent extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Renew Driver License");
    }

    static void staticMethod() {
        System.out.println("UnvStudent - Static Method");
    }
}
