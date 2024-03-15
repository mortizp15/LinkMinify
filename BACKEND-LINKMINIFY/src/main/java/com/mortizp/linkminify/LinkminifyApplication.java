package com.mortizp.linkminify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LinkminifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkminifyApplication.class, args);
	}

}
