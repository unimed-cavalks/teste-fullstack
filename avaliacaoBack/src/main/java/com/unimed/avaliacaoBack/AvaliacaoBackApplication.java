package com.unimed.avaliacaoBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.SecurityConfig;

@SpringBootApplication
@Import(SecurityConfig.class)
public class AvaliacaoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoBackApplication.class, args);
	}

}
