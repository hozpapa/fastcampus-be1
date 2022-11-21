package me.day11.statics.uses;

public class CarMain {
    public static void main(String[] args) {
        // " 클래스 이름 . 정적 필드 "
        // 클래스가 로딩될 때 정적 필드 / 메소드는 같이 로딩이 되기 때문에 클래스와 관련이 있음
        // 객체 생성 유무와 상관없이 호출이 가능함
        // 정적 필드는 클래스 로더에 의해 객체보다 먼저 생성
        // 정적 필드들은 컴파일 타임에 생성
        // 객체는 런타임에 생성
        // 정적 필드 == 클래스 변수

        System.out.println(Car.getBrandName()); // 객체 생성 전에도 호출 가능


        Car car = new Car(); // Car 클래스의 객체 car
        System.out.println(car);
        // " 객체 이름 . 정적 필드 " (호출 가능은 함, 권장하지는 않음)
        // 객체와는 관련이 없음

        // 처음에는 car 객체 안의 필드이름이 BRAND
        // 없으면 Car 클래스 안에 정적 필드 이름이 BRAND
        System.out.println(car.getBrandName()); // (호출 가능은 함, 권장하지는 않음)
        System.out.println(Car.getBrandName());

    }
}
