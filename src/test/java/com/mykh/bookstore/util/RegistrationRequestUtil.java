package com.mykh.bookstore.util;


import com.mykh.bookstore.registration.model.RegistrationRequest;

public class RegistrationRequestUtil {

    public static RegistrationRequest defaultRequest() {
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("defaultemail@gmail.com");
        request.setFirstName("Dwight");
        request.setLastName("Schrute");
        request.setPassword("z@Lypia");
        return request;
    }

}
