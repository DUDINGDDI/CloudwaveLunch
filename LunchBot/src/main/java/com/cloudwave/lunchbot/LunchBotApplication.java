package com.cloudwave.lunchbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LunchBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LunchBotApplication.class, args);
	}

}
