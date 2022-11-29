package me.day16.practice.practice01;

public class InputNegativeException extends Exception {
    private static final String MESSAGE = "InputsEmptyException";
    public InputNegativeException() {
        super(MESSAGE);
    }

    public InputNegativeException(String message) {
        super(message);
    }

    public InputNegativeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputNegativeException(Throwable cause) {
        super(cause);
    }

}
