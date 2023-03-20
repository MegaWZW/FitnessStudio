package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.repository.UserRepository;
import com.it_academy.final_proj.fitness.service.UserService;
import com.it_academy.final_proj.fitness.service.api.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserServiceConfig {

	@Bean
	public IUserService userService(UserRepository repository, PasswordEncoder encoder){
		return new UserService(repository, encoder);
	}
}
