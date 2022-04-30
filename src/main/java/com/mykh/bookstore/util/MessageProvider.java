package com.mykh.bookstore.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Service
public class MessageProvider {

    @Value("Confirm your email")
    private String confirmEmail;

    @Value("http://localhost:8080/api/v1/registration/confirm?token=")
    private String tokenConfirmationLink;
}
