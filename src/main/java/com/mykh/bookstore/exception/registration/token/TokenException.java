package com.mykh.bookstore.exception.registration.token;

import com.mykh.bookstore.exception.registration.RegistrationException;

public class TokenException extends RegistrationException {

    public TokenException(String s) {
        super(s);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
