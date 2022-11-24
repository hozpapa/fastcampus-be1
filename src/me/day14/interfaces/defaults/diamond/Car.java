package me.day14.interfaces.defaults.diamond;

public class Car implements Driveable, Sleepable {

    @Override
    public void on() {
        Driveable.super.on();
    }

    @Override
    public void off() {
        Driveable.super.off();
    }
}
