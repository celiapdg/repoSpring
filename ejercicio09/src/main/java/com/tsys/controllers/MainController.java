package com.tsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping(value = {"/hola","/hello","/salut"})
	@ResponseBody
	public String saludar() {
		return "Hello, hola, salut";
	}

}
