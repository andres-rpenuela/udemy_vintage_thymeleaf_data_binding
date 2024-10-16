package com.tokioschool.spring.web.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tokioschool.spring.web.form.dto.UserFormDTO;

@Controller
public class FormMvcController {
	
	@GetMapping({"","/","/form"})
	public String form(Model model) {
		model.addAttribute("title", "Formulario usuarios");
		return "form";
	}
	
	@PostMapping("/form")
	public String process(Model model, 
			@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam("email") String emailUser) {
		
		model.addAttribute("title", "Resultado");
		
		// send to view param each
		/*model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", emailUser);*/
		
		// send to view the params wrappers in object
		UserFormDTO userFormDTO = UserFormDTO.builder()
				.name(username)
				.email(emailUser)
				.password(password)
				.build();
		
		model.addAttribute("user", userFormDTO);
		return "result";	
	}

}
