package com.mykh.bookstore.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class YAMLConfiguration {

    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();
}
