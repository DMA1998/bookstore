package com.mykh.bookstore.service.book;

import com.mykh.bookstore.model.book.Book;
import com.mykh.bookstore.repository.book.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void testBookCrudRepository() {
        Optional<Book> employeesOptional = bookRepository.findById(127L);
        //....
    }

}
