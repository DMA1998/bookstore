package com.mykh.bookstore.exception.email;

public class EmailSendException extends EmailException {

    public EmailSendException(String s) {
        super(s);
    }

    public EmailSendException(String message, Throwable cause) {
        super(message, cause);
    }
}
