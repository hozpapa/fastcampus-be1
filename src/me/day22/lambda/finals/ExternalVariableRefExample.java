package me.day22.lambda.finals;

import java.util.concurrent.atomic.AtomicInteger;

public class ExternalVariableRefExample {
    private int a;

    public ExternalVariableRefExample() {
        a = 20;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        int num = 10; // compiler: 값이 초기화된 후에 값을 수정하지 않으면 final
        System.out.println("num = " + num);
        // 외부 지역 변수를 람다식에서 사용하는 경우 final 이어야 함
        // 변수가 초기화되고 값의 변화가 한 번도 없다면 컴파일러에서는 해당 변수를 final로 취급 => effectively final

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        // 왜? 멀티쓰레드 환경에서, 람다식이 먼저 실행될 지, 외부 참조 변수가 변경되는 부분이 먼저 실행될 지는 알 수 없음
        //    만약 외부에서 참조 변수가 변경된다면 멀티 쓰레드 환경에서 람다식의 외부 지역 변수를 참조한 값이 바뀔 수 있기 때문 (함수의 순수성)
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        Runnable runnable1 = () -> System.out.println("runnable1 = " + num);
        Runnable runnable2 = () -> System.out.println("runnable2 = " + num);
        runnable1.run();
        runnable2.run();
//        num++; // uncomment 하게 되면 람다식의 num이 오류남
        System.out.println("num = " + num);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////
        // 문제를 해결하기 위해 AtomicInteger에 공유 객체 저장
        // https://steady-coding.tistory.com/568
        ////////////////////////////////////////////////////////////////////////////////////
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println("atomicInteger = " + atomicInteger);

        Runnable runnable3 = () -> System.out.println("runnable3 = " + atomicInteger); // Thread
        Runnable runnable4 = () -> System.out.println("runnable4 = " + atomicInteger); // Thread
        runnable3.run(); // 10
        runnable4.run(); // 10 => 20
        atomicInteger.addAndGet(10); // 20
        System.out.println("atomicInteger = " + atomicInteger); // main memory : atomicInteger






    }
}
