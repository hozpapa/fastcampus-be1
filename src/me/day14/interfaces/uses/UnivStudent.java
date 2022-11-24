package me.day14.interfaces.uses;

public class UnivStudent extends Person implements DriveLicenseAble, StudentSaleAble {
    @Override
    public void renew() {
        System.out.println("UnivStudent - Renew Driver License");
    }

    static void staticMethod() {
        System.out.println("UnivStudent - Static Method");
    }
}
