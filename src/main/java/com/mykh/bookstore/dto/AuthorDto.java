package com.mykh.bookstore.dto;

import lombok.Builder;

@Builder
public class AuthorDto {

    private Long id;
    private String title;
    private String book;

}
