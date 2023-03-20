package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.repository.AccountRepository;
import com.it_academy.final_proj.fitness.service.AccountService;
import com.it_academy.final_proj.fitness.service.api.IEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AccountServiceConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AccountService accountService(AccountRepository repository, IEmailService emailService, PasswordEncoder encoder) {
		return new AccountService(repository, emailService, encoder);
	}
}
