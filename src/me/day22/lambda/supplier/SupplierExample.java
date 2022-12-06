package me.day22.lambda.supplier;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "java8";
        System.out.println(supplier.get());

        IntSupplier intSupplier = () -> (int) (Math.random() * 45) + 1;
        System.out.println(intSupplier.getAsInt());
    }
}
