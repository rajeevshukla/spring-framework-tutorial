package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {

	
	@RequestMapping("hello")
	public void hello(){
		System.out.println("Welcome");
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//-Dspring.profile.active=PROD
}
