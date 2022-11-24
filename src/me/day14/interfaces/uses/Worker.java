package me.day14.interfaces.uses;

public class Worker implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Worker - Renew Driver License");
    }

    @Override
    public void defaultMethod() {
        System.out.println("Worker - Default Method");
    }
}
