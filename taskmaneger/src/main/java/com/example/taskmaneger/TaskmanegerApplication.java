package com.example.taskmaneger;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TaskmanegerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanegerApplication.class, args);
		
		System.out.println("byeee");
	}
	@Bean
    public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
 
}
