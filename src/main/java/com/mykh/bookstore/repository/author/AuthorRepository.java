package com.mykh.bookstore.repository.author;

import com.mykh.bookstore.model.author.Author;
import com.mykh.bookstore.model.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
