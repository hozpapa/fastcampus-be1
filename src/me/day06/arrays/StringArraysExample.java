package me.day06.arrays;

public class StringArraysExample {
    public static void main(String[] args) {
        String[] names = {"Sally", "John", "Jacob", "Kelly", "Minna"};
        System.out.println("names = " + names);

        for (int i = 0; i < names.length; i++) {
            System.out.println("names[i] = " + names[i]); // 주소가 나오진 않음 (데이터가 나오도록 toString() 정의)
        }
    }
}
