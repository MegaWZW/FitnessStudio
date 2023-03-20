package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.user.UserRegistrationDTO;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserRegistrationDTOToUserEntity implements Converter<UserRegistrationDTO, UserEntity> {
	@Override
	public UserEntity convert(UserRegistrationDTO source) {
		return new UserEntity(source);
	}
}
