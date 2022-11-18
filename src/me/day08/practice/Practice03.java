package me.day08.practice;

public class Practice03 {
    public static void main(String[] args) {
        String[] strings = new String[100000];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = Integer.toString(i);
        }


        // https://medium.com/javarevisited/java-compiler-optimization-for-string-concatenation-7f5237e5e6ed
        /* 런타임시 StringConcatFactory.makeConcatWithConstants()을 통해 StringBuilder 로 변경되어 실행됨 */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String answer = "";
                for (String string: strings) {
                    answer += string;
                }

            }
        });
//        StringConcatFactory.makeConcatWithConstants();

        /* 새로운 공간을 만들어 반환하기 때문에 복사하는 시간으로 속도가 느려질 수 밖에 없음 */
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String answer = "";
                for (String string: strings) {
                    answer.concat(string);
                }

            }
        });

        thread1.start();
        thread2.start();
    }

}
