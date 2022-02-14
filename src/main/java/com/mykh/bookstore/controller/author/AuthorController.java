package com.mykh.bookstore.controller.author;

import com.mykh.bookstore.service.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

}
