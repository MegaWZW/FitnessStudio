package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.user.UserCreateDTO;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;


public class UserCreateDTOToUserEntity implements Converter<UserCreateDTO, UserEntity> {
	@Override
	public UserEntity convert(UserCreateDTO source) {
		return new UserEntity(source);
	}
}
