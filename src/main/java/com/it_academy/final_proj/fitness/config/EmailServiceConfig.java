package com.it_academy.final_proj.fitness.config;

import com.it_academy.final_proj.fitness.service.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class EmailServiceConfig {
	@Bean
	public EmailServiceImpl emailService(JavaMailSender sender){
		return new EmailServiceImpl(sender);
	}
}
