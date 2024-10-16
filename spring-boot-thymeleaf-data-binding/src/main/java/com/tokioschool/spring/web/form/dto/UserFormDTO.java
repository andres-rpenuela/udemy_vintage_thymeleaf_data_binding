package com.tokioschool.spring.web.form.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserFormDTO {
	
	private String name;
	private String password;
	private String email;

}
