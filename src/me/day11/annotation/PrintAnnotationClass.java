package me.day11.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;


// 런타임시에 클래스 정보나 메소드 정보를 얻기 쉽지 않음
// 객체와 연결된 (바인딩) 메소드 정보는 객체 내부에 메소드 주소를 저장함
// 런타임시에 바이트코드를 분석해서 클래스 정보나 메소드 정보를 얻을 수 있음 => 리플렉션 (코드 분석, 리팩토링)
public class PrintAnnotationClass {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods(); // 리플렉션 (클래스 / 어노테이션 정보)
        System.out.println(Arrays.toString(methods));
        /*
        Service service = new Service();
        service.method1();
        service.method2();
        service.method3();
        */
        for (Method method : methods) {
            // PrintAnnotation 적용되었는지 확인
            if (method.isAnnotationPresent(PrintAnnotation.class)) {
                // PrintAnnotation 객체 얻기
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

                // 메소드 이름 출력
                System.out.println("[" + method.getName() + "]");
                // 구분선 출력
                for (int i = 0; i < printAnnotation.number(); i++) {
                    System.out.print(printAnnotation.value());
                }
                System.out.println();

                try {
                    // 메소드 호출 (리플렉션)
                    method.invoke(new Service());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
