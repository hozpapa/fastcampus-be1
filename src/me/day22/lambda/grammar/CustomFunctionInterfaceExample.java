package me.day22.lambda.grammar;

public class CustomFunctionInterfaceExample {
    public static void main(String[] args) {
        CustomFunctionInterface1.staticMethod();

        CustomFunctionInterface1 f1 = () -> System.out.println("hello world!");
        f1.lambda();
        f1.defaultMethod();
        System.out.println();
        ///////////////////////////////////////////////////////////////////


        CustomFunctionInterface2.staticMethod();

//        CustomFunctionInterface2 f2 = (a) -> System.out.println(a);
        CustomFunctionInterface2 f2 = a -> System.out.println(a);
        f2.lambda(10);
        f2.lambda("hello world");
        f2.lambda(new Something("hello world", 10));
        f2.defaultMethod();
        System.out.println();
        ///////////////////////////////////////////////////////////////////


        CustomFunctionInterface3.staticMethod();

        CustomFunctionInterface3 f3 = arguments -> {
            for (Object arg: arguments) {
                System.out.print(arg + ",");
            }
            System.out.println();
        };
        f3.lambda();
        f3.lambda(10);
        f3.lambda(10, 20);
        f3.lambda(10, 20, 30);
        f3.lambda(10, 20, 30, 40, 50);
        f3.defaultMethod();
        System.out.println();
        ///////////////////////////////////////////////////////////////////


        CustomFunctionInterface4.staticMethod();

//        CustomFunctionInterface4 f4 = (a, b) -> { return a + b; };
        CustomFunctionInterface4 f4 = (a, b) -> a + b;
        System.out.println(f4.lambda(1, 2));
        System.out.println(f4.lambda(3, 4));
        System.out.println(f4.lambda(100, 200));
        System.out.println(f4.lambda(300, 400));

        f4.defaultMethod();
        ///////////////////////////////////////////////////////////////////


        CustomFunctionInterface5.staticMethod();

        CustomFunctionInterface5 f5 = arguments -> {
            String str = "";
            for (Object arg: arguments) {
                str += arg;
            }
            return str;
        };
        System.out.println(f5.lambda());
        System.out.println(f5.lambda(1));
        System.out.println(f5.lambda(1, 2));
        System.out.println(f5.lambda(1, 2, 3, 4));
        System.out.println(f5.lambda("a"));
        System.out.println(f5.lambda("a", "b"));
        System.out.println(f5.lambda("a", "b", "c"));
        System.out.println(f5.lambda("a", "b", "c", "d"));
        f5.defaultMethod();

    }
}

class Something {
    private String string;
    private Integer integer;

    public Something() {
    }

    public Something(String string, Integer integer) {
        this.string = string;
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Something{" +
                "string='" + string + '\'' +
                ", integer=" + integer +
                '}';
    }
}
