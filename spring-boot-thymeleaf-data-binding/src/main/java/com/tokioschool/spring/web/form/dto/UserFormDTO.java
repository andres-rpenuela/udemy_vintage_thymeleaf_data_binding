package com.tokioschool.spring.web.form.dto;

import com.tokioschool.spring.web.form.validation.identification.IdentificationRegex;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserFormDTO {
	@NotEmpty
	@Size(min=3,max = 8,message = "Tamaño no permitido") //number digits, only string
	private String username;
	@NotEmpty(message="El nombre no puede ser vacío")
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email(message="Email incorrecto") 
	private String email;
	
	@Min(5) @Max(90) // range of number
	private Integer age;

	// no estará en el formulario como input, por lo que al recibir el formulario, Spring
	// pone el campo del objeto a nulo, para solventarlo, usar "Session Attribute" o "input hidden"
	private String identificador;
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificationRegex
	private String identificadorNumber;
}
