package com.tokioschool.spring.web.form.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserFormDTO {
	@NotEmpty
	private String username;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;

	// no estará en el formulario como input, por lo que al recibir el formulario, Spring
	// pone el campo del objeto a nulo, para solventarlo, usar "Session Attribute" o "input hidden"
	private String identificador; 
}
