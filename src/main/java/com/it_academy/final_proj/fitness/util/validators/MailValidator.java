package com.it_academy.final_proj.fitness.util.validators;

import com.it_academy.final_proj.fitness.util.validators.annotations.MailConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MailValidator implements ConstraintValidator<MailConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null
				&& value.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
	}

	@Override
	public void initialize(MailConstraint constraintAnnotation) {

	}
}
