package com.it_academy.final_proj.fitness.util.validators.annotations;

import com.it_academy.final_proj.fitness.util.validators.UUIDValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UUIDValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UUIDConstraint {
	String message() default "Невалидный UUID";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
