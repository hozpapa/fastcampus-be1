package me.day13.polymorphism.definition;

public class Main {
    public static void main(String[] args) {
        /*
        * <다형성>
        *
        * 자식 객체가 부모 객체 변수에 살 수 있음
        * SuperClass super = new SubClass(); (O)
        *
        * 부모 객체는 자식 객체 변수에 살 수 없음
        * SubClass sub = new SuperClass(); (x)
        * */

        Shape shape = new Circle();
        System.out.println(shape.centerPoint);

        if (shape instanceof Circle) {
            System.out.println(((Circle) shape).radius);
        }
        // shape -- type casting --> circle

        // shape: centerPoint
        // circle: centerPoint, radius

//        Circle circle = new Shape();
//        System.out.println(circle.centerPoint);
//        System.out.println(circle.radius); // ?


        System.out.println(shape.getCenterPoint());
        System.out.println(((Circle)shape).getRadius());

        // Shape: centerPoint
        // Circle: centerPoint, radius

        Circle circle = (Circle) new Shape(); // Shape < Circle
        System.out.println(circle.getCenterPoint());
        System.out.println(circle.getRadius());


        // Shape
        //  - Circle
        //  - Rectangle
        //  - Triangle
    }
}
