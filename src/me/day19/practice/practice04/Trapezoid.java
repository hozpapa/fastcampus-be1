package me.day19.practice.practice04;

import java.util.Arrays;

public class Trapezoid extends Shape {
    private static final int NUM_OF_LINES = 4;
    private Line[] lines; // 윗변, 아랫변, 왼쪽, 오른쪽 변으로 들어온다고 가정

    public Trapezoid() {
        lines = new Line[NUM_OF_LINES];

        for (int i = 0; i < NUM_OF_LINES; i++) {
            lines[i] = new Line();
        }
    }


    public Trapezoid(Line[] lines) {
        this.lines = lines;
    }

    public Line[] getLines() {
        return lines;
    }

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    @Override
    public void draw() {
        System.out.println(Trapezoid.class.getClass() + " draw()");
    }

    @Override
    public double calculateArea() {
        Line upper = lines[0];
        Line lower = lines[1];

        int upperLength = Math.abs(upper.getEnd().getX() - upper.getStart().getX());
        int lowerLength = Math.abs(lower.getEnd().getX() - lower.getStart().getX());
        int height = Math.abs(lower.getEnd().getY() - upper.getEnd().getY());
        return (upperLength + lowerLength) * height * 0.5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trapezoid trapezoid = (Trapezoid) o;
        return Arrays.equals(lines, trapezoid.lines);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lines);
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "lines=" + Arrays.toString(lines) +
                '}';
    }

    @Override
    public void scale(int offset) {
        return;
    }
}
