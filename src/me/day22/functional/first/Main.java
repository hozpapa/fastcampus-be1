package me.day22.functional.first;

public class Main {
    public static void main(String[] args) {
//         Func func1 = a -> System.out.println(a); // 람다식 표현
//         Func func2 = new Func() { // 익명 객체 표현
//            @Override
//            void method(Object a) {
//                System.out.println(a);
//            }
//         }
//         func2.method(3);


        Func func = s -> System.out.println(s); // 함수를 변수로 저장
        func.method("this is functional interface");
    }
}
