package com.mykh.bookstore.model.user;

import java.time.LocalDate;

public class User {
    //primary key
    private int id;
    private String username;
    private String password;
    private LocalDate dateOfBirthday;
    private String email;
    private String phone;
    private boolean admin;
    //foreign key
    private int bookId;
}
