package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.user.UserDTO;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserDTO implements Converter<UserEntity, UserDTO> {
	@Override
	public UserDTO convert(UserEntity source) {
		return new UserDTO(source);
	}
}
