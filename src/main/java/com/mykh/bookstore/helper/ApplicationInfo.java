package com.mykh.bookstore.helper;

import com.mykh.bookstore.configuration.YAMLConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Current class displays all useful information about application based on multiple configurations
 */
@Slf4j
@Configuration
public class ApplicationInfo {

    @Autowired
    private YAMLConfig config;

    public void yamlConfigurationInfo() {
        log.info("using environment: " + config.getEnvironment());
        log.info("name: " + config.getName());
        log.info("enabled: " + config.isEnabled());
        log.info("servers: " + config.getServers());
    }
}
