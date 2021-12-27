package com.mykh.bookstore;

import com.mykh.bookstore.helper.ApplicationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    ApplicationHelper helper;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
        helper.yamlConfigurationInfo();
    }
}
