package com.icr7.springBootBasics;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(Controller.class);

	@Value("${my.name}")
	String name;

	@GetMapping("/v1")
	public String get(){
		logger.trace("Controller hit");
		logger.debug("Controller hit");
		logger.info("Controller hit");
		logger.warn("Controller hit");
		logger.error("Controller hit");
		return "hi there "+name;
	}
}

@Configuration
@PropertySource("classpath:ishwar-info-${spring.profiles.active}.properties")
class config{

}
