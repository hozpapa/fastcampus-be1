package me.day22.lambda.defaults.andThenCompose;

import java.util.function.Consumer;

public class ConsumerAndThenExample {
    public static void main(String[] args) {
        Consumer<Member> consumerA = m -> System.out.println("consumerA: " + m.getName());
        Consumer<Member> consumerB = m -> System.out.println("consumerB: " + m.getName());
        Consumer<Member> consumerAB = consumerA.andThen(consumerB);

        consumerAB.accept(new Member("kim", "kim1234", new Address()));
    }
}
