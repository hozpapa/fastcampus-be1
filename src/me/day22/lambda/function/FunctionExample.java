package me.day22.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample {
    private static List<Student> students = Arrays.asList(
            new Student("kim", 20, 80),
            new Student("lee", 25, 50),
            new Student("park", 29, 100)
    );

    public static String mapToString(Student student, Function<Student, String> function) {
        return function.apply(student);
    }

    public static int mapToInt(Student student, ToIntFunction<Student> function) {
        return function.applyAsInt(student);
    }

    public static double average(ToIntFunction<Student> function) {
        int sum = 0;
        for (Student student: students) {
            sum += function.applyAsInt(student);
        }
        return (double)sum / students.size();
    }

    public static void main(String[] args) {
        for (Student student: students) {
            System.out.println(mapToString(student, t -> t.getName()));
        }
        System.out.println();
        /////////////////////////////////////////////////

        for (Student student: students) {
            System.out.println(mapToInt(student, t -> t.getAge()));
        }
        System.out.println();

        for (Student student: students) {
            System.out.println(mapToInt(student, t -> t.getScore()));
        }
        System.out.println();
        /////////////////////////////////////////////////

        System.out.printf( "age average = %f\n", average( t -> t.getAge() ));
        System.out.printf( "score average = %f\n", average( t -> t.getScore() ));
    }
}
