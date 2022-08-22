package com.academic.auth;

import com.academic.auth.models.Roles;
import com.academic.auth.models.Users;
import com.academic.auth.services.RoleService;
import com.academic.auth.services.UserService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableEncryptableProperties
@SecurityScheme(name = "academicauthservice", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
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
//			userService.addUser(new Users(null, "admin", "admin12321", null));
//			userService.addUser(new Users(null, "djodi", "djodi12321", null ));
//			userService.addUser(new Users(null, "jalal", "jalal12321", null ));
//
//			userService.addRoleToUser("admin", "ROLE_ADMIN");
//			userService.addRoleToUser("djodi", "ROLE_STUDENT");
//			userService.addRoleToUser("jalal", "ROLE_LECTURER");
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
