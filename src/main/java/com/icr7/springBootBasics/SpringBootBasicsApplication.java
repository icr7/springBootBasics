package com.icr7.springBootBasics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootBasicsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}

}
@RestController
@RequestMapping("/test")
class Controller{

	@Value("${my.name}")
	String name;

	@GetMapping("/v1")
	public String get(){
		return "hi there "+name;
	}
}

@Configuration
@PropertySource("classpath:ishwar-info-${spring.profiles.active}.properties")
class config{

}
