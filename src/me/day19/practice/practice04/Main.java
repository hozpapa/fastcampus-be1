package me.day19.practice.practice04;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3),
                new Rectangle(3, 5),
                new Triangle(5, 3),
                new Trapezoid(new Line[]{
                        new Line(new Point(3, 0), new Point(8, 0)),
                        new Line(new Point(1, 10), new Point(10, 10)),
                        new Line(new Point(3, 0), new Point(1, 10)),
                        new Line(new Point(8, 0), new Point(10, 10))})};

        for (int i = 0; i < shapes.length; i++) {
            Point point = new Point((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1);
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

    }

    // 객체지향적이지 않은 코드 🤔
    // => shape.calculateArea();
    public static double calculateArea(Shape shape) { // Shape shape = new Circle() / new Rectangle() / new Triangle()
        final double PI = 3.14;
        if (shape instanceof Circle) {
            return ((Circle) shape).getRadius() * ((Circle) shape).getRadius() * PI;
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getWidth() * ((Rectangle) shape).getHeight();
        } else if (shape instanceof Triangle) {
            return ((Triangle) shape).getBase() * ((Triangle) shape).getHeight() * 0.5;
        } else {
            return 0.0;
        }
    }
}
