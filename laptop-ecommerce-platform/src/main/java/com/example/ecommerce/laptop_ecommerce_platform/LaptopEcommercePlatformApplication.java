package com.example.ecommerce.laptop_ecommerce_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LaptopEcommercePlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaptopEcommercePlatformApplication.class, args);
	}

}

