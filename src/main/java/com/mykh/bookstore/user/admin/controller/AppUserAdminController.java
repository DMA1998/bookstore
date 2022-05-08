package com.mykh.bookstore.user.admin.controller;

import com.mykh.bookstore.user.admin.service.AppUserAdminService;
import com.mykh.bookstore.user.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AppUserAdminController {

    private final AppUserAdminService appUserAdminService;

    @GetMapping("/update")
    public String updateAdmins(Model model) {
        appUserAdminService.updateAdmins();
        List<User> admins = appUserAdminService.findAdmins();
        model.addAttribute("admins", admins);
        return "admins";
    }
}
