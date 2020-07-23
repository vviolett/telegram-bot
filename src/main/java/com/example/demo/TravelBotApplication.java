package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TravelBotApplication {

	public static void main(String[] args)
	{
		ApiContextInitializer.init();
		SpringApplication.run(TravelBotApplication.class, args);
	}
}
