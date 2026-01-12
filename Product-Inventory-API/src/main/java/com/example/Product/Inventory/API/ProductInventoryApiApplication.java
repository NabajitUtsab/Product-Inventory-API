package com.example.Product.Inventory.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductInventoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInventoryApiApplication.class, args);
	}

}
