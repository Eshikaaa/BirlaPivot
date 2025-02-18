package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
@EnableTransactionManagement
@SpringBootApplication
public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
