package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan
@ComponentScan({"com.example.crud"})

public class CrudServiceTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudServiceTddApplication.class, args);
	}

}
