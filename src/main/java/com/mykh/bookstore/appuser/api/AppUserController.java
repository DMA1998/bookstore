package com.mykh.bookstore.appuser.api;

import com.mykh.bookstore.appuser.model.AppUser;
import com.mykh.bookstore.appuser.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@RestController
@RequestMapping(path = "api/v1/find/")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping(path = "/users")
    public List<AppUser> getUsers() {
        return appUserService.getAllUsers().get();
    }

    @GetMapping(path = "/{id}")
    public AppUser getUser(@PathVariable("id") Long id) {
        return appUserService.getUserById(id).get();
    }

}
