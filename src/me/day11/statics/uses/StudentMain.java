package me.day11.statics.uses;


import me.day10.object.tostring.Semester;

public class StudentMain {
    public static void main(String[] args) {
        System.out.println("학생 수 = " + Student.getNumOfStudent());
        for (int i = 0; i < Semester.values().length; i++) {
            System.out.println(i + " => " + Semester.values()[i]);
        }

        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(Character.toString('a' + i),
                    Semester.values()[i % Semester.values().length]);
            // % Semester.values().length == % 9
            // 나머지: 0 ~ 8
            System.out.println("학생 수 = " + Student.getNumOfStudent());
            System.out.println(students[i]);
            System.out.println();
        }
    }
}
