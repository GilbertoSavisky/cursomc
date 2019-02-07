package com.savisky.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Bean
	public boolean instantiateDatabase() {
		
		return true;
	}

}
