package me.day14.practice.practice03;

import me.day14.practice.practice01.Electronic;
import me.day14.practice.practice01.Electronics;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Electronics electronics = new Electronics(new Electronic[] {
                new Electronic("0001", "", Electronic.Company.SAMSUNG, LocalDate.of(2021, 2, 12), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FACE}),
                new Electronic("0002", "", Electronic.Company.LG, LocalDate.of(2020, 12, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.PATTERN}),
                new Electronic("0003", "", Electronic.Company.APPLE, LocalDate.of(2017, 5, 10), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN}),
                new Electronic("0004", "", Electronic.Company.SAMSUNG, LocalDate.of(2018, 7, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT}),
                new Electronic("0005", "", Electronic.Company.LG, LocalDate.of(2022, 3, 20), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT, Electronic.AuthMethod.PATTERN, Electronic.AuthMethod.FACE}),
                new Electronic("0006", "", Electronic.Company.APPLE, LocalDate.of(2022, 6, 30), new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGERPRINT})});
        System.out.println(electronics);
        System.out.println();

        // Electronic[][]
        Electronics[] groupByResults = electronics.groupByCompanyName();
        System.out.println(groupByResults[0]);
        System.out.println(groupByResults[1]);
        System.out.println(groupByResults[2]);
        // groupByResults[0]: SAMSUNG
        // groupByResults[1]: LG
        // groupByResults[2]: APPLE
    }
}
