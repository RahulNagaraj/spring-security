package com.rahuln.springsecurity;

import com.rahuln.springsecurity.models.Role;
import com.rahuln.springsecurity.models.User;
import com.rahuln.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Rahul", "rahul123", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "Vi", "vi123", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "ViRa", "vira123", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "ABC", "abc123", "abc123", new ArrayList<>()));
			userService.saveUser(new User(null, "XYZ", "xyz123", "abc123", new ArrayList<>()));

			userService.addRoleToUser("rahul123", "ROLE_USER");
			userService.addRoleToUser("rahul123", "ROLE_ADMIN");
			userService.addRoleToUser("rahul123", "ROLE_MANAGER");
			userService.addRoleToUser("vi123", "ROLE_USER");
			userService.addRoleToUser("abc123", "ROLE_ADMIN");
			userService.addRoleToUser("xyz123", "ROLE_MANAGER");

		};
	}

}
