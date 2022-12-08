package me.day24.logging.custom;

public class Main {
    public static void main(String[] args) {
        CustomLogger customLogger = CustomLogger.getInstance();
        customLogger.log("log test");
    }
}
