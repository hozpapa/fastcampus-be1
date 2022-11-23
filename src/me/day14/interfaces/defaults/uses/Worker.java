package me.day14.interfaces.defaults.uses;

public class Worker implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Renew Drive License");
    }
}
