package com.example.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring2Application {

	public static void main(String[] args)
	{
		//dependency inj
		ApplicationContext context= SpringApplication.run(Spring2Application.class, args);
		dev obj= context.getBean(dev.class);
		obj.build();
	}

}
