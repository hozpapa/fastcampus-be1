package me.day19.practice.practice02;

import me.day19.practice.practice01.Electronic;
import me.day19.practice.practice01.Electronics;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Electronics electronics = new Electronics(new Electronic[]{
                new Electronic("0001", "", Electronic.Company.SAMSUNG, LocalDate.of(2021, 2, 12), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FACE}),
                new Electronic("0002", "", Electronic.Company.LG, LocalDate.of(2020, 12, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.PATTERN}),
                new Electronic("0003", "", Electronic.Company.APPLE, LocalDate.of(2017, 5, 10), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN}),
                new Electronic("0004", "", Electronic.Company.SAMSUNG, LocalDate.of(2018, 7, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT}),
                new Electronic("0005", "", Electronic.Company.LG, LocalDate.of(2022, 3, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.PATTERN, Electronic.AuthMethod.FACE}),
                new Electronic("0006", "", Electronic.Company.APPLE, LocalDate.of(2022, 6, 30), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT})});
        System.out.println(electronics);


        String findProductNo = "1010";
        Electronic findResult = electronics.findByProductNo(findProductNo);
        if (findResult != null) {
            System.out.println(findResult);
        } else {
            System.out.printf("productNo (%s) can't be found.\n", findProductNo);
        }

    }
}