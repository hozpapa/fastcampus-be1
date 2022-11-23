package me.day13.inheritance.use;

import java.util.Objects;


public class Car { // 테스라만 만드는 공장
    protected String ID; // auto-generated
    protected String modelName;
    protected int speed;
    protected static final String COMPANY = "TESLA";
    private static int numOfCar = 0;

    public Car() {
        numOfCar++;
        ID = String.format("%04d", numOfCar);
    }

    public Car(String modelName, int speed) {
        numOfCar++;
        this.ID = String.format("%04d", numOfCar);
        this.modelName = modelName;
        this.speed = speed;
    }

    public String getID() {
        return ID;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSpeed() {
        return speed;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public static int getNumOfCar() {
        return numOfCar;
    }

    public static void setNumOfCar(int numOfCar) {
        Car.numOfCar = numOfCar;
    }

    @Override // Object equals()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && ID.equals(car.ID) && modelName.equals(car.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, modelName, speed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", modelName='" + modelName + '\'' +
                ", speed=" + speed +
                '}';
    }
}