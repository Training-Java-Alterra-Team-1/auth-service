package com.academic.auth;

import com.academic.auth.dto.RoleDto;
import com.academic.auth.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(RoleService roleService){
//		return args ->{
//			roleService.addRole(new RoleDto("ROLE_ADMIN"));
//			roleService.addRole(new RoleDto("ROLE_STUDENT"));
//			roleService.addRole(new RoleDto("ROLE_LECTURER"));
//		};
//	}

}
