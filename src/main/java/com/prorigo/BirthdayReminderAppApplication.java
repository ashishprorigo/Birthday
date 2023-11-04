package com.prorigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthdayReminderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdayReminderAppApplication.class, args);
	}

}
