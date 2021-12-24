package com.mykh.bookstore.controller.book;

import com.mykh.bookstore.model.book.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    @GetMapping
    public List<Book> getBooks() {
        return List.of(new Book("Davidov"),
                new Book("Marmeladov"),
                new Book("Chocolatov"));
    }

}
