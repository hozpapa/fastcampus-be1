package me.day13.polymorphism.arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Shape(), new Circle(), new Rectangle(), new Triangle() };
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw(); // 동적 바인딩 (가상 메서드 테이블 기준으로)
        }
    }
}
