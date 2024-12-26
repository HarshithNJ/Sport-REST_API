package org.sports.sport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Group CRUD API", version = "1.0", description = "API documentation for Group CRUD operations", contact = @Contact(name = "Harshith N J", email = "harshith@example.com")))
public class SportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);
	}

}
