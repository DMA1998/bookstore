package com.mykh.bookstore.appuser.admin.controller;

import com.mykh.bookstore.appuser.admin.service.AppUserAdminService;
import com.mykh.bookstore.appuser.model.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v2/admins")
@AllArgsConstructor
public class AppUserAdminController {

    private final AppUserAdminService appUserAdminService;

    @GetMapping("/reload")
    public String updateAdmins(Model model) {
        appUserAdminService.setAdmins();
        List<AppUser> admins = appUserAdminService.findAdmins();
        model.addAttribute("admins", admins);
        return "admins";
    }

}
