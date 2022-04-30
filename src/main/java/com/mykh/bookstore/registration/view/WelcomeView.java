package com.mykh.bookstore.registration.view;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class WelcomeView {

    @GetMapping(value = "/welcome")
    public String showWelcome() {
        //language=html
        return "welcome";
    }
}
