package com.mykh.bookstore.registration.email.validation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmailValidatorTest {

    @Autowired
    private EmailValidator emailValidator;

    @Test
    @Order(1)
    @Description("Test email on successful validation")
    void emailSuccessfullyValidating() {
        //given
        List<String> emails = List.of(
                "anymai2@gmail.com",
                "any$mail@yahoo.com",
                "a1nymail@ukr.net");

        //when
        int index = new Random().nextInt(emails.size());
        String email = emails.get(index);
        boolean isEmailValid = emailValidator.test(email);

        //then
        assertThat(isEmailValid).isTrue();
    }

    @Test
    @Order(2)
    @Description("Email should not be validating")
    void emailValidationFailed() {
        //given
        List<String> emails = List.of(
                "anymai@l2@gmail.com",
                "anymail.com",
                "anymail",
                "anymail@dsadascom",
                "%sada@gmail.com");

        //when
        int index = new Random().nextInt(emails.size());
        String email = emails.get(index);
        boolean isValidEmail = emailValidator.test(email);

        //then
        assertThat(isValidEmail).isFalse();
    }
}
