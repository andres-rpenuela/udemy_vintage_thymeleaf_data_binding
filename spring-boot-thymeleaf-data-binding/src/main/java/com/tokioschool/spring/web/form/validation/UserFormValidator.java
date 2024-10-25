package com.tokioschool.spring.web.form.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tokioschool.spring.web.form.dto.UserFormDTO;

@Component
public class UserFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// give support only to instances of UserFormDTO.class
		return UserFormDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final UserFormDTO user = UserFormDTO.class.cast(target);
		
		/** Ejemplo de validacion usando ValidationUtils de Spring **/
		// nombre del atrituo a validar, key del mensaje de error definido en messaje.properites
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userFormDto.name");
		/*
		// alternativa
		if(user.getName().isEmpty()) {
			errors.rejectValue("name", "NotEmpty.userFormDto.name");
		}
		*/
		
		/** Ejemplo de validacion manual **/
		/*
		if(user.getIdentificadorNumber().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") == false) {
			// nombre del atrituo a validar, key del mensaje de error definido en messaje.properites 
			// si no existe, se crea
			errors.rejectValue("identificadorNumber", "pattern.usuario.identificadorNumber");
		}*/
	}

}
