package com.mykh.bookstore.exception.email;

import com.mykh.bookstore.exception.registration.RegistrationException;

public class EmailException extends RegistrationException {

    public EmailException(String s) {
        super(s);
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
