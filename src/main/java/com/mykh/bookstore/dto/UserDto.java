package com.mykh.bookstore.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private LocalDate dateOfBirthday;
    private String email;
    private String phone;
}
