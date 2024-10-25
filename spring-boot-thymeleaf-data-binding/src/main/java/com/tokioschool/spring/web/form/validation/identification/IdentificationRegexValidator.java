package com.tokioschool.spring.web.form.validation.identification;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class IdentificationRegexValidator implements ConstraintValidator<IdentificationRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}");
	}

}
