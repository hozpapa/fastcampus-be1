package me.day25.smartstore.exception;

import me.day25.smartstore.util.Message;

public class InputNullException extends Exception {

    public InputNullException() {
        super(Message.ERR_MSG_INVALID_INPUT_NULL);
    }

    public InputNullException(String message) {
        super(message);
    }
}
