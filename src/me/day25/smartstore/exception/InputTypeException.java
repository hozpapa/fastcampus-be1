package me.day25.smartstore.exception;

import me.day25.smartstore.util.Message;

public class InputTypeException extends Exception {
    public InputTypeException() {
        super(Message.ERR_MSG_INVALID_INPUT_TYPE);
    }

    public InputTypeException(String message) {
        super(message);
    }
}
