package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@ImportResource("classpath:applicationContext-aop.xml")
@SpringBootApplication
public class ScorrtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorrtApplication.class, args);
	}

}
