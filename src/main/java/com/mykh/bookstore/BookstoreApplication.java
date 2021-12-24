package com.mykh.bookstore;

import com.mykh.bookstore.configuration.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private YAMLConfig config;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("using environment: " + config.getEnvironment());
		System.out.println("name: " + config.getName());
		System.out.println("enabled:" + config.isEnabled());
		System.out.println("servers: " + config.getServers());
	}
}
