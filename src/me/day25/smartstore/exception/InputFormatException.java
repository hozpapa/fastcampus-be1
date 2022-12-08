package me.day25.smartstore.exception;

import me.day25.smartstore.util.Message;

public class InputFormatException extends Exception {
    public InputFormatException() {
        super(Message.ERR_MSG_INVALID_INPUT_FORMAT);
    }

    public InputFormatException(String message) {
        super(message);
    }
}
