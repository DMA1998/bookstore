package com.mykh.bookstore.controller.book;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    @GetMapping()
    public String index(Model model) {
        // Get all the people in our DAO and display them in browser
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model) {
            //  Get a person by id from DAO and put him to display in the timelife
        return null;
    }
}
