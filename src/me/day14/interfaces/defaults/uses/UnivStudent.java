package me.day14.interfaces.defaults.uses;

public class UnivStudent extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Renew Drive License");
    }
}
