package com.mykh.bookstore.registration.email;

public interface EmailSender {

    void send(String to, String email);
}
