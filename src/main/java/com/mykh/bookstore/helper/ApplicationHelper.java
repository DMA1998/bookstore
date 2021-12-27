package com.mykh.bookstore.helper;

import com.mykh.bookstore.configuration.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationHelper {

    @Autowired
    private YAMLConfig config;

    public void yamlConfigurationInfo() {
        System.out.println("using environment: " + config.getEnvironment());
        System.out.println("name: " + config.getName());
        System.out.println("enabled: " + config.isEnabled());
        System.out.println("servers: " + config.getServers());
    }
}
