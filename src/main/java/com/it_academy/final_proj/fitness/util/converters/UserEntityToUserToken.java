package com.it_academy.final_proj.fitness.util.converters;

import com.it_academy.final_proj.fitness.core.dto.user.UserTokenCreate;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserToken implements Converter<UserEntity, UserTokenCreate> {

	@Override
	public UserTokenCreate convert(UserEntity source) {
		return new UserTokenCreate(source);
	}
}
