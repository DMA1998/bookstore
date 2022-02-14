package com.mykh.bookstore;

import com.mykh.bookstore.helper.ApplicationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RequiredArgsConstructor
@EntityScan("com.mykh.bookstore.model")
@EnableJpaRepositories("com.mykh.bookstore.repository")
public class BookstoreApplication implements CommandLineRunner {

    private final ApplicationInfo info;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
        info.yamlConfigurationInfo();
    }
}
