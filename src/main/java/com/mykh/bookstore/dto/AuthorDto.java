package com.mykh.bookstore.dto;

import com.mykh.bookstore.model.book.Book;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirthday;
    private Set<Book> books;

}
