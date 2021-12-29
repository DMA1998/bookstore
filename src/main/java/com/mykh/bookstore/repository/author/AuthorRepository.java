package com.mykh.bookstore.repository.author;

import com.mykh.bookstore.model.author.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
