package com.it_academy.final_proj.fitness.service;

import com.it_academy.final_proj.fitness.core.dto.user.UserTokenCreate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

	public UserTokenCreate getUser(){
		return (UserTokenCreate) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
