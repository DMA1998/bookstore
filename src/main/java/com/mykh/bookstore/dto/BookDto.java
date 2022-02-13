package com.mykh.bookstore.dto;

import com.mykh.bookstore.model.author.Author;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class BookDto {

    private Long id;
    private String title;
    private LocalDate publishingDate;
    private Author author;
}
