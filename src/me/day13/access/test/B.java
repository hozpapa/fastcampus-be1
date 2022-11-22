package me.day13.access.test;

import me.day13.access.A;

public class B extends A {

    public static void main(String[] args) {
        int pub = new B().pub;
        int pro = new B().pro;
//        int def = new B().def;
//        int pri = new B().pri;
    }
}
