package me.day06.function;

public class MainFunctionExample { // 클래스 로더
    /*
     * 함수: 공통적인 기능을 분리/모듈화해서 작성하기 위함
     * 메서드: 객체지향에서 함수를 메서드 (함수의 작은 범위)
     * */

    public static void main(String[] args) { // 메인함수 호출
        int res1 = sigma(1);
        System.out.println("res1 = " + res1);

        int res2 = sigma(10);
        System.out.println("res2 = " + res2);

        int x = 1;
        int y = 2;
        System.out.printf("swap 함수 외부 (전): [%d %d]\n", x, y);
        int[] res = swap(x, y); // 1, 2
        System.out.printf("swap 함수 외부 (후): [%d %d]\n", x, y);

        x = res[0];
        y = res[1];
        System.out.printf("swap 함수 외부 (후): [%d %d]\n", x, y);
        System.out.println("=======================================================");

        x = 1;
        y = 2;
        int[] vars = new int[]{x, y}; // 배열의 이름에는 주소값을 가지고 있음
        System.out.println("vars = " + vars);
        System.out.printf("swap 함수 외부 (전): [%d %d]\n", vars[0], vars[1]);
        swap(vars); // 200
        System.out.printf("swap 함수 외부 (후): [%d %d]\n", vars[0], vars[1]);
    }


    public static int sigma(int n) { // int n = 1, int n = 10 개발자 개발할 때 개발 단위
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // call by value (data)
    public static int[] swap(int x, int y) { // int x = 1 (value), int y = 2 (value);
        // x = 1, y = 2
        // x = 2, y = 1

        System.out.printf("swap 함수 내부 (전): [%d %d]\n", x, y);
        int temp; // tmp
        temp = x;
        x = y;
        y = temp;
        System.out.printf("swap 함수 내부 (후): [%d %d]\n", x, y);

        return new int[]{x, y};
    }


    // call by reference (참조자 C++) (X)
    // call by value (address)
    public static void swap(int[] args) { // args = 200 (address value), arg[0]: 1, arg[1]: 2 => swap => arg[0]: 2, arg[1]: 1
        System.out.println("args = " + args);
        System.out.printf("swap 함수 내부 (전): [%d %d]\n", args[0], args[1]);
        int temp; // tmp

        // 원본을 직접 참조
        // args = 200 (원본 데이터가 있는 공간)
        temp = args[0]; // 200 번지에 있는 원소값을 temp 에 저장해라
        args[0] = args[1]; // 204 번지에 있는 원소값을 200 번지에 넣어라
        args[1] = temp; // temp 에 저장한 값을 204 번지에 넣어라
        System.out.printf("swap 함수 내부 (후): [%d %d]\n", args[0], args[1]);
    }


    // 자바 함수의 한계: 반환값이 두 개 이상이 불가능함 => 해결방법: 배열이나 객체 전달
    public static Aggregation sumAndAverage(int n) { // int n = 1, int n = 10
        int sum = 0;
        double average = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        average = (double) sum / n;
        return new Aggregation(sum, average);
    }

}
