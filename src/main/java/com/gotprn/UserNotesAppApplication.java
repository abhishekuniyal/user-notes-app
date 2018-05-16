package com.gotprn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserNotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserNotesAppApplication.class, args);
	}
}
