package com.advoc8.som.hackathon.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.advoc8.som.hackathon.storage.StorageProperties;
import com.advoc8.som.hackathon.storage.StorageService;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class Advoc8Configuration {
	
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
	
}
