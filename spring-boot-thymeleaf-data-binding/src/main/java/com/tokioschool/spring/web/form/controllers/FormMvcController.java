package com.tokioschool.spring.web.form.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tokioschool.spring.web.form.dto.UserFormDTO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FormMvcController {
	
	@GetMapping({"","/","/form"})
	public String form(Model model) {
		model.addAttribute("title", "Formulario usuarios");
		model.addAttribute("userFormDto", new UserFormDTO());
		return "form";
	}
	
	@PostMapping("/form")
	public String process(Model model, 
			/*@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam("email") String emailUser*/
			@Valid @ModelAttribute("userFormDto") UserFormDTO userFormDTO, BindingResult result) {
		
		/** example 1 **/
		// send to view param each
		/*model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", emailUser);
		return "result";	
		*/
		/** example 2 **/
		// send to view the params wrappers in object
		/*UserFormDTO userFormDTO = UserFormDTO.builder()
				.name(username)
				.email(emailUser)
				.password(password)
				.build();
		model.addAttribute("user", userFormDTO);
		return "result";
		*/	
		/** example 3 **/
		if(result.hasErrors()) {
			Map<String,String> errors = new HashMap<>();
			result.getFieldErrors().forEach(error->{
				log.debug("process handler say: Error field %s".formatted(error.getField()));
				errors.put(
						error.getField(),
						"El campo %s %s".formatted(error.getField(),error.getDefaultMessage())
				);
			});
			model.addAttribute("title", "Formulario usuarios: Con errores");
			model.addAttribute("error", errors);
			return "form";
		}
		model.addAttribute("title", "Resultado");
		model.addAttribute("user", userFormDTO);
		return "result";
	}

}
