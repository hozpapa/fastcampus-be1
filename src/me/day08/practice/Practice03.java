package me.day08.practice;

public class Practice03 {
    public static void main(String[] args) {
        String[] strings = new String[100000];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = Integer.toString(i);
        }


        // https://medium.com/javarevisited/java-compiler-optimization-for-string-concatenation-7f5237e5e6ed
        /* 바이트코드 수정을 줄이기 위해 런타임시 StringConcatFactory.makeConcatWithConstants()을 통해 StringBuilder 로 변경되어 실행됨 */
        /* StringConcatFactory.makeConcatWithConstants() 변환하는 시간이 이전에 비해 발생함 */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();

                String answer = "";
                for (String string: strings) {
                    answer += string;
                }
                long end = System.currentTimeMillis();
                System.out.printf("%s: %5d ms\n", Thread.currentThread().getName(), end - start);
            }
        }, "thread1");
//        StringConcatFactory.makeConcatWithConstants();

        /* 새로운 공간을 만들어 반환하기 때문에 복사하는 시간으로 속도가 느려질 수 밖에 없음 */
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();

                String answer = "";
                for (String string: strings) {
                    answer.concat(string);
                }
                long end = System.currentTimeMillis();
                System.out.printf("%s: %5d ms\n", Thread.currentThread().getName(), end - start);
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }

}
