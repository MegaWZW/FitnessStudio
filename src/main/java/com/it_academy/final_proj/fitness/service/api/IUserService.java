package com.it_academy.final_proj.fitness.service.api;

import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserService {
	Page<UserEntity> getPage(Integer page, Integer pageSize);
	UserEntity get(UUID uuid);
	void add(UserEntity entity);
	void delete(UUID uuid, LocalDateTime dtUpdate);
	void update(UserEntity newUser, UUID uuid, LocalDateTime dtUpdate);
}
