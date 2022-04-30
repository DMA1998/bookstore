package com.mykh.bookstore.registration.view;

import com.mykh.bookstore.registration.model.RegistrationRequest;
import com.mykh.bookstore.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class RegistrationView {

    private final RegistrationService registrationService;

    @GetMapping(value = "/api/v2/registration")
    public String handleForm(Model model) {
        RegistrationRequest request = new RegistrationRequest();
        model.addAttribute("request",request);
        return "registration";
    }

    @PostMapping(value = "/api/v2/registration")
    public String successForm(@ModelAttribute("request") RegistrationRequest request) {

        return "welcome";
    }

 /*   @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<RegistrationRequest> registeration(WebRequest webRequest, Model model) {
        RegistrationRequest request = new RegistrationRequest();
        model.addAttribute("request", request);
        return "registration";
    }*/

    @PostMapping(path = "api/v1/registration/view")
    public String register(@ModelAttribute RegistrationRequest request) {
        return registrationService.register(request);
    }


}
