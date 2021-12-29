package com.mykh.bookstore.helper;

import com.mykh.bookstore.configuration.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Current class displays all useful "inside" information about application based on multiple configurations
 */
@Configuration
public class ApplicationInfo {

    @Autowired
    private YAMLConfig config;

    public void yamlConfigurationInfo() {
        System.out.println("using environment: " + config.getEnvironment());
        System.out.println("name: " + config.getName());
        System.out.println("enabled: " + config.isEnabled());
        System.out.println("servers: " + config.getServers());
    }
}
