package com.tokioschool.spring.web.form.validation.requeried;


import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeriedValidator implements ConstraintValidator<Requeried, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Optional.ofNullable(value)
				.map(StringUtils::stripToNull)
				.filter(org.springframework.util.StringUtils::hasText)
				.isPresent();
	}

}
