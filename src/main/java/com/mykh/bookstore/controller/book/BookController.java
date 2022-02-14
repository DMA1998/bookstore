package com.mykh.bookstore.controller.book;

import com.mykh.bookstore.model.book.Book;
import com.mykh.bookstore.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

}
