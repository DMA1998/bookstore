package com.mykh.bookstore.appuser.view;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppUserViewController {

    private final AppUserService appUserService;

    @GetMapping()
    public String showWelcomePage() {
        return "welcome";
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<AppUser> appUsers = appUserService.getAllUsers().get();
        model.addAttribute("appUsers", appUsers);
        return "users";
    }

}
