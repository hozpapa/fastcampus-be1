package me.day22.practice.practice01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "kiwi");
        String longest = words.stream().reduce((w1, w2) -> (w1.length() > w2.length()) ? w1 : w2).get();
        System.out.println("longest = " + longest);
    }
}
