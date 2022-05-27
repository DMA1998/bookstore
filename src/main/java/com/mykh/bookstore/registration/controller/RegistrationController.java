package com.mykh.bookstore.registration.controller;

import com.mykh.bookstore.registration.model.RegistrationRequest;
import com.mykh.bookstore.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String registrationView(Model model) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        model.addAttribute("request", registrationRequest);
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("request") RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
