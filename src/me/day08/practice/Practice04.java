package me.day08.practice;

import java.util.StringTokenizer;

public class Practice04 {
    public static void main(String[] args) {
        String str = "";

        for (int i = 0; i < 1000000; i++) {
            str += i + ", ";
        }

        final String STR = str;

        //////////////////////////////////////////

        /* 새로운 공간을 만들어 반환하기 때문에 복사하는 시간으로 속도가 느려질 수 밖에 없음 */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                String[] splitString = STR.split(", ");
                long end = System.currentTimeMillis();
                System.out.printf("%5d ms\n", end - start);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                StringTokenizer stringTokenizer = new StringTokenizer(STR, ", ");

                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                }
                long end = System.currentTimeMillis();
                System.out.printf("%5d ms\n", end - start);
            }
        });

        thread1.start();
        thread2.start();
    }
}
