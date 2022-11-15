package me.day07.enums;

import java.util.Arrays;

public class EnumsExample {
    public static void main(String[] args) {
        System.out.println("\n=================");
        System.out.println("** authorizations");
        System.out.println(Authorization.ADMIN);
        System.out.println(Authorization.DEV);
        System.out.println(Authorization.TEST);
        System.out.println(Authorization.USER);
        System.out.println("\n=================");


        Authorization[] authorizations = Authorization.values();
        for (Authorization authorization: authorizations) {
            System.out.println(authorization.ordinal() + " => " + authorization);
        }

        System.out.println();
        System.out.println("\n=================");
        String[] authorizationStrings = new String[authorizations.length];
        for (int i = 0; i < authorizationStrings.length; i++) {
            authorizationStrings[i] = authorizations[i].toString();
        }
        System.out.println(Arrays.toString(authorizationStrings));

        for (int i = 0; i < authorizationStrings.length; i++) {
            Authorization authorization = Authorization.valueOf(authorizationStrings[i]);
            System.out.println(authorization);
        }

    }
}
