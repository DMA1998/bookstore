package com.mykh.bookstore.repository.book;

import com.mykh.bookstore.model.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
