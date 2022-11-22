package me.day13.access;

public class A {
    public int pub;
    protected int pro;
    int def;
    private int pri;

    public void method1() {
        int i = pri;
    }
}
