package com.api.journalingApp.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class JournalApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JournalApplication.class, args);
	}

}
