package com.frenos_el_control.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.frenos_el_control.principal.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
