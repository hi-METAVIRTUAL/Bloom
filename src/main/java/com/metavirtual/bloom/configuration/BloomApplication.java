package com.metavirtual.bloom.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.metavirtual.bloom")
public class BloomApplication {
	public static void main(String[] args) {
		SpringApplication.run(BloomApplication.class, args);
	}

}
