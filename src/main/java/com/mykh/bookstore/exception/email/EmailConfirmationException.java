package com.mykh.bookstore.exception.email;

public class EmailConfirmationException extends EmailException {

    public EmailConfirmationException(String s) {
        super(s);
    }

    public EmailConfirmationException(String message, Throwable cause) {
        super(message, cause);
    }
}
