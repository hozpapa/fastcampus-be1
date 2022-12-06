package me.day22.lambda.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    private static List<Student> students = Arrays.asList(
            new Student("kim", 20, 80),
            new Student("dong", 19, 60),
            new Student("kil", 17, 70),
            new Student("yoon", 16, 100),
            new Student("lee", 25, 50),
            new Student("park", 29, 100),
            new Student("choi", 39, 70),
            new Student("kang", 31, 80),
            new Student("lim", 32, 60)
    );

    public static double averageIf(Predicate<Student> predicate) {
        int count = 0;
        int sum = 0;

        for ( Student student: students ) {
            if ( predicate.test(student) ) {
                sum += student.getScore();
                count++;
            }
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {
        double average30 = averageIf( t -> t.getAge() >= 30 ); // 30 살 이상 학생들의 평균 점수
        System.out.println("average30 = " + average30);

        double average20 = averageIf( t -> t.getAge() < 20 ); // 20 살 미만 학생들의 평균 점수
        System.out.println("average20 = " + average20);
    }
}
