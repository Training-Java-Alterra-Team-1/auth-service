package com.academic.auth;

import com.academic.auth.models.Roles;
import com.academic.auth.models.Users;
import com.academic.auth.services.RoleService;
import com.academic.auth.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RoleService roleService, UserService userService){
		return args ->{
//			roleService.addRole(new Roles(null, "ROLE_ADMIN"));
//			roleService.addRole(new Roles(null, "ROLE_STUDENT"));
//			roleService.addRole(new Roles(null, "ROLE_LECTURER"));
//
//			userService.addUser(new Users(null, "admin", "admin12321", new Long(1)));
//			userService.addUser(new Users(null, "djodi", "djodi12321", new Long(2)));
//			userService.addUser(new Users(null, "jalal", "jalal12321", new Long(3)));
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
