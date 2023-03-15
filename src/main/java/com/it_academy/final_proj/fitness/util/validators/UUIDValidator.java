package com.it_academy.final_proj.fitness.util.validators;

import com.it_academy.final_proj.fitness.util.validators.annotations.UUIDConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<UUIDConstraint, UUID> {

	@Override
	public boolean isValid(UUID value, ConstraintValidatorContext context) {
		return value != null
				&& value.toString().matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
	}

	@Override
	public void initialize(UUIDConstraint constraintAnnotation) {

	}
}
