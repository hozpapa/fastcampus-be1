package me.day13.inheritance.use;

import java.util.Objects;

public class SportCar extends Car {
    // 부모한테서 상속받은 필드
//    protected String ID; // auto-generated
//    protected String modelName;
//    protected int speed;
//    protected static final String COMPANY = "TESLA";
//    protected static int numOfCar = 0;


    // 컴파일러가 부모 객체 super 생성
    // 눈으로는 안보이지만 내부적으로 super 존재함
    // Car super = new Car();가 살고 있음
    private int turbo;

    public SportCar() {
        //super(); // 내부적으로 자동 호출
    }

    public SportCar(int turbo) {
        //super(); // 내부적으로 자동 호출
        this.turbo = turbo;
    }

    public SportCar(String modelName, int speed, int turbo) {
        super(modelName, speed);
        this.turbo = turbo;
    }

    public int getTurbo() {
        return turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return turbo == sportCar.turbo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turbo);
    }

    @Override
    public String toString() { // Object 클래스의 toString() 재정의
        return "SportCar{" + super.toString() + ", " + // 부모 객체 호출
                "turbo=" + turbo +
                '}';
    }
}
