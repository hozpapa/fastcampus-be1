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


        // "ADMIN" (String) == mapper ==> Authorization.ADMIN (Authorization)
        // Authorization.valueOf("ADMIN") => ADMIN
        System.out.println();
        System.out.println("\n=================");
        String[] authorizationStrings = new String[authorizations.length];
        for (int i = 0; i < authorizationStrings.length; i++) {
            authorizationStrings[i] = authorizations[i].toString(); // "ADMIN", "DEV", "TEST", "USER"
        }
        System.out.println(Arrays.toString(authorizationStrings));

        for (int i = 0; i < authorizationStrings.length; i++) {
            Authorization authorization = Authorization.valueOf(authorizationStrings[i]);
            System.out.println(authorization);
        }
        System.out.println();

        Authorization a = Authorization.ADMIN;
        String st = a.toString();
        System.out.println(st);

        Authorization re = Authorization.valueOf(st);
        System.out.println(re);

        System.out.println(Authorization.valueOf("ADMIN"));
        System.out.println(Authorization.valueOf("admin")); // IllegalArgumentException

    }
}
