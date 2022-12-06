package me.day22.lambda.statics.minByMaxBy;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.BinaryOperator;


public class OperatorMinByMaxByExample {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

//        binaryOperator = BinaryOperator.minBy( (f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()) );
//        binaryOperator = BinaryOperator.maxBy( (f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()) );

        binaryOperator = BinaryOperator.minBy(Comparator.comparingInt(Fruit::getPrice));
        fruit = binaryOperator.apply(new Fruit("strawberry", 6000), new Fruit("watermelon", 10000));
        System.out.println("minBy = " + fruit.getName());

        binaryOperator = BinaryOperator.maxBy(Comparator.comparingInt(Fruit::getPrice));
        fruit = binaryOperator.apply(new Fruit("strawberry", 6000), new Fruit("watermelon", 10000));
        System.out.println("maxBy = " + fruit.getName());
    }
}


class Fruit {
    private String name;
    private Integer price;

    public Fruit() {
    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) && Objects.equals(price, fruit.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}