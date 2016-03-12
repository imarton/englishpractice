package org.martoni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EnglishpracticeApplication {

	@RequestMapping("/")
	public String home() {
		return "Welcome  in our Home!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EnglishpracticeApplication.class, args);
	}
}
