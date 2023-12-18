package com.example.supplychain1;

import com.example.supplychain1.model.RawMaterial;
import com.example.supplychain1.service.RawMaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Supplychain1Application {

	public static void main(String[] args) {
		SpringApplication.run(Supplychain1Application.class, args);
	}
}
