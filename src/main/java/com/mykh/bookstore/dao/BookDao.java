package com.mykh.bookstore.dao;

import com.mykh.bookstore.model.book.Book;

import java.util.List;

public interface BookDao {

    List<Book> getAllBooks();

    void updateBook();

    void deleteBook();

    void addBook();
}
