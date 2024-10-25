package com.tokioschool.spring.web.form.validation.identification;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = IdentificationRegexValidator.class)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER })
public @interface IdentificationRegex {
	String message() default "Identificador no valido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
