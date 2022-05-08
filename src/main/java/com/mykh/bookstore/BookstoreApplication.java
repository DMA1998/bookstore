package com.mykh.bookstore;

import com.mykh.bookstore.user.admin.service.AppUserAdminService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class BookstoreApplication implements CommandLineRunner {

    private final AppUserAdminService appUserAdminService;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
        appUserAdminService.updateAdmins();
    }
}
