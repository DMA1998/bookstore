package com.mykh.bookstore.exception.registration;

public  class RegistrationException extends IllegalStateException {

    public RegistrationException(String s) {
        super(s);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

}
