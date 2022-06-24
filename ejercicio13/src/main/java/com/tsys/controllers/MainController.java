package com.tsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/{valor}")
	@ResponseBody
	public String parOImpar(@PathVariable int valor) {
		if (valor%2==0) return "Es par";
		return "Es impar";
	}

}
