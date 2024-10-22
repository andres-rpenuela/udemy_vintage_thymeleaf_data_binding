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
	private String name;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;

}
