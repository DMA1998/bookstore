package com.mykh.bookstore.controller.book;

import com.mykh.bookstore.helper.ApplicationHelper;
import com.mykh.bookstore.model.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    @Autowired
    ApplicationHelper applicationHelper;

    @GetMapping
    public List<Book> getBooks() {
        return new ArrayList<>();
    }
}
