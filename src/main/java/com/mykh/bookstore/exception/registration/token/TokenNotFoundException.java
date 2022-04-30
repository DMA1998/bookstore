package com.mykh.bookstore.exception.registration.token;

public class TokenNotFoundException extends TokenException {

    public TokenNotFoundException(String s) {
        super(s);
    }

    public TokenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
