package com.it_academy.final_proj.fitness.util.validators.annotations;

import com.it_academy.final_proj.fitness.util.validators.MailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MailConstraint {
	String message() default "Невалидный eMail";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
