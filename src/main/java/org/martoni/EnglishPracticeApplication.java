package org.martoni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EnglishPracticeApplication extends SpringBootServletInitializer{

//	private static final Logger log = LoggerFactory.getLogger(EnglishPracticeApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EnglishPracticeApplication.class);
	}
	
	@RequestMapping("/")
	public String home() {
		return "Welcome  in our Home!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EnglishPracticeApplication.class, args);
	}
	
}
