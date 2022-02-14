package com.mykh.bookstore.helper;

import com.mykh.bookstore.configuration.YAMLConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApplicationInfoImpl implements ApplicationInfo {

    private final YAMLConfiguration yamlConfiguration;

    @Override
    public void yamlConfigurationInfo() {
        log.info("using environment: " + yamlConfiguration.getEnvironment());
        log.info("name: " + yamlConfiguration.getName());
        log.info("enabled: " + yamlConfiguration.isEnabled());
        log.info("servers: " + yamlConfiguration.getServers());
    }
}
