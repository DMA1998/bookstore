package com.mykh.bookstore.model.author;

import com.mykh.bookstore.model.book.Book;

import java.time.LocalDate;
import java.util.List;

public class Author {
    //primary key
    private int id;
    private String firstName;
    private String secondName;
    private String summary;
    private List<Book> books;
    private LocalDate dateOfBirthday;
}
