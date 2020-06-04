package com.summitworks.ngo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories("com.summitworks.ngo.repo") 
@EntityScan("com.summitworks.ngo.entities")
@SpringBootApplication
public class NgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgoApplication.class, args);
	}

}
