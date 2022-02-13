package com.mykh.bookstore.helper;

import com.mykh.bookstore.configuration.YAMLConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * Current class displays all useful information about application based on multiple configurations
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class ApplicationInfo {

    private final YAMLConfig config;

    public void yamlConfigurationInfo() {
        log.info("using environment: " + config.getEnvironment());
        log.info("name: " + config.getName());
        log.info("enabled: " + config.isEnabled());
        log.info("servers: " + config.getServers());
    }
}

