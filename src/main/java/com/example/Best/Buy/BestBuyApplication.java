package com.example.Best.Buy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BestBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestBuyApplication.class, args);
		System.out.println("aaa");
	}

}
