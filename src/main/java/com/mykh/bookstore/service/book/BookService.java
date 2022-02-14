package com.mykh.bookstore.service.book;

import com.mykh.bookstore.model.book.Book;
import com.mykh.bookstore.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}
