package com.mykh.bookstore.book.service;

import com.mykh.bookstore.book.model.Book;
import com.mykh.bookstore.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        log.info("Fetched all authors");
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        log.info("Finding author by id: {}",id);
        return bookRepository.findById(id);
    }
}
