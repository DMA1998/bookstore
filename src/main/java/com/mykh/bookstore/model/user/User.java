package com.mykh.bookstore.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private LocalDate dateOfBirthday;
    private String email;
    private String phone;
    private boolean admin;
    //foreign key
    private int bookId;
}
