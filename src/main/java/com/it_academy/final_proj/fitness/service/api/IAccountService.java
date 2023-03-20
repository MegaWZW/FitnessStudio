package com.it_academy.final_proj.fitness.service.api;

import com.it_academy.final_proj.fitness.core.dto.user.UserLoginDTO;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;

import java.util.UUID;

public interface IAccountService {
	void register(UserEntity entity);
	void verify(String code, String mail);
	UserEntity login(UserLoginDTO dto);
	UserEntity getCard(String mail);
	UserEntity getUserByMail(String mail);
}
