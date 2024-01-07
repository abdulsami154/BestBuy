package com.example.Best.Buy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BestBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBuyApplication.class, args);
		System.out.println("Started");
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
