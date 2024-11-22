package com.example.foodieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class FoodieAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodieAppApplication.class, args);
		System.out.println("Foodie App API is running...");
	}
}
