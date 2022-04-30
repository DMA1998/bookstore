package com.mykh.bookstore.exception.email;

public class EmailValidationException extends IllegalStateException {

    public EmailValidationException(String s) {
        super(s);
    }

    public EmailValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
