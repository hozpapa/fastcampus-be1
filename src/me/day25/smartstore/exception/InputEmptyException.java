package me.day25.smartstore.exception;

import me.day25.smartstore.util.Message;

public class InputEmptyException extends Exception {

    public InputEmptyException() {
        super(Message.ERR_MSG_INVALID_INPUT_EMPTY);
    }

    public InputEmptyException(String message) {
        super(message);
    }
}
