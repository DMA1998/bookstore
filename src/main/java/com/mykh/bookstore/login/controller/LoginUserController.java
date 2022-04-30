package com.mykh.bookstore.login.controller;

import com.mykh.bookstore.login.model.LoginRequest;
import com.mykh.bookstore.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginUserController {

    private final LoginService loginService;

    @GetMapping
    public String loginView(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("login_request", loginRequest);
        return "login";
    }

    @PostMapping("/confirm")
    public void confirmLogin(@ModelAttribute("request") @Valid LoginRequest request) {
        loginService.checkUser(request);
    }

}
