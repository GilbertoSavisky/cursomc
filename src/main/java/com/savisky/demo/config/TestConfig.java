package com.savisky.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Bean
	public boolean instantiateDatabase() {
		
		return true;
	}

}
