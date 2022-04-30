package com.mykh.bookstore.exception.registration;

public class UserPresentException extends RegistrationException {

    public UserPresentException(String s) {
        super(s);
    }

    public UserPresentException(String message, Throwable cause) {
        super(message, cause);
    }
}
