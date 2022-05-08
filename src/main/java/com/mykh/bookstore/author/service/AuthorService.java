package com.mykh.bookstore.author.service;

import com.mykh.bookstore.author.model.Author;
import com.mykh.bookstore.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        log.info("Fetched all authors");
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        log.info("Finding author by id: {}",id);
        return authorRepository.findById(id);
    }
}
