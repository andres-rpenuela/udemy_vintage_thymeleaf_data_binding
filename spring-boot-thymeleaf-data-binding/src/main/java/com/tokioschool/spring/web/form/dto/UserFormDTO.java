package com.tokioschool.spring.web.form.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tokioschool.spring.web.form.validation.identification.IdentificationRegex;
import com.tokioschool.spring.web.form.validation.requeried.Requeried;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFormDTO {
	//@NotEmpty
	@Requeried
	@Size(min = 3, max = 8, message = "Tamaño no permitido") // number digits, only string
	private String username;
	
	//@NotEmpty(message = "El nombre no puede ser vacío")
	@Requeried
	private String name;
	// @NotEmpty
	@Requeried
	private String surname;
	// @NotEmpty
	@Requeried
	private String password;

	// @NotEmpty
	@Requeried
	@Email(message = "Email incorrecto")
	private String email;

	@Min(5)
	@Max(90) // range of number
	private int age;

	@NotNull
	@Min(5)
	@Max(90) // range of number
	private Integer account;
	// no estará en el formulario como input, por lo que al recibir el formulario,
	// Spring
	// pone el campo del objeto a nulo, para solventarlo, usar "Session Attribute" o
	// "input hidden"
	private String identificador;

	// @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificationRegex
	private String identificadorNumber;
	
	
	@NotNull
	//@DateTimeFormat(pattern = "yyyy/MM/dd" ) // esto se aplico solo para el fiel de la validacin
	//@DateTimeFormat(pattern = "yyyy-MM-dd" ) // patron en caso de usar input date de HTML 5, se valida con InitBinder
	@PastOrPresent
	private Date birthDate;
}
