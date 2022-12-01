package me.day19.practice.practice06;

import me.day19.practice.practice04.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(3), new Rectangle(3, 5), new Triangle(5, 3) };

        for (int i = 0; i < shapes.length; i++) {
            Point point = new Point((int)(Math.random()*10) + 1, (int)(Math.random()*10) + 1);
            shapes[i].setCenterPoint(point);
        }

        System.out.println("[ Shape Info. ] ");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i]);
        }
        System.out.println();

        System.out.println("[ Shape Area ] ");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i].calculateArea());
        }
        System.out.println();

        System.out.println("[ Shape Translate ] ");
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].translate(10, 10);
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i]);
        }
        System.out.println();

        System.out.println("[ Shape Scale ] ");
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].scale(2);
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i]);
        }
        System.out.println();

    }
}
