package com.tokioschool.spring.web.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tokioschool.spring.web.form.dto.UserFormDTO;
import com.tokioschool.spring.web.form.validation.UserFormValidator;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SessionAttributes("userFormDto")
@RequiredArgsConstructor
public class FormMvcController {
	
	private final UserFormValidator userFormValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setValidator(userFormValidator); // se cepilla todos los validadores
		binder.addValidators(userFormValidator); // cohexiste con el resto de validadoress
	}
	
	@GetMapping( )
	public String form(Model model) {
		/** ejemplo 1- 4 **/
		/*model.addAttribute("title", "Formulario usuarios");
		model.addAttribute("userFormDto", new UserFormDTO());
		return "form";*/
		/** ejemplo 5 **/
		final UserFormDTO userFormDTO = UserFormDTO.builder().name("Andres").surname("Jhon").identificador("123.523.132-K").build();
		model.addAttribute("title", "Formulario usuarios");
		model.addAttribute("userFormDto", userFormDTO);
		return "form";
		
	}
	
	@PostMapping("/form")
	public String process(Model model, 
			/*@RequestParam(name="username") String username,
			@RequestParam String password,
			@RequestParam("email") String emailUser*/
			@Valid @ModelAttribute("userFormDto") UserFormDTO userFormDTO, BindingResult result, SessionStatus sessionStatus) {
		
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
		/*
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
		*/
		/** ejemplo 4 **/
		/*if(result.hasErrors()) {
			model.addAttribute("title", "Formulario usuarios: Con errores");
			return "form";
		}
		model.addAttribute("title", "Resultado");
		model.addAttribute("user", userFormDTO);
		return "result";*/
		/** ejemplo 5 **/
		/*
		if(result.hasErrors()) {
			model.addAttribute("title", "Formulario usuarios: Con errores");
			return "form";
		}
		model.addAttribute("title", "Resultado");
		model.addAttribute("user", userFormDTO); // user != userFormDto
		sessionStatus.setComplete(); // limpia los datos
		return "result";*/
		/** ejemplo 6 **/
		/*
		userFormValidator.validate(userFormDTO, result); //BindingResult es de tipo Errors
		if(result.hasErrors()) {
			model.addAttribute("title", "Formulario usuarios: Con errores");
			return "form";
		}
		model.addAttribute("title", "Resultado");
		model.addAttribute("user", userFormDTO); // user != userFormDto
		sessionStatus.setComplete(); // limpia los datos
		return "result";
		*/
		/** ejemplo 6 **/
		//userFormValidator.validate(userFormDTO, result); // registrado en initbinder
		if(result.hasErrors()) {
			model.addAttribute("title", "Formulario usuarios: Con errores");
			return "form";
		}
		model.addAttribute("title", "Resultado");
		model.addAttribute("user", userFormDTO); // user != userFormDto
		sessionStatus.setComplete(); // limpia los datos
		return "result";
	}

}
