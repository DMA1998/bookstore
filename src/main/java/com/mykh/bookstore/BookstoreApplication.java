package com.mykh.bookstore;

import com.mykh.bookstore.helper.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@SpringBootApplication
@Configuration
@EntityScan("com.mykh.bookstore.model")
@EnableJpaRepositories("com.mykh.bookstore.repository")
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    ApplicationInfo info;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
        info.yamlConfigurationInfo();
    }
}
