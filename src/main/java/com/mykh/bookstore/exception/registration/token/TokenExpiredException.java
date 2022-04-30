package com.mykh.bookstore.exception.registration.token;

public class TokenExpiredException extends TokenException {

    public TokenExpiredException(String s) {
        super(s);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
