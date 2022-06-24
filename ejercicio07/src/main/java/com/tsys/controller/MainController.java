package com.tsys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {
	
	@RequestMapping("/hacercafe")
	@ResponseStatus(HttpStatus.OK) // respuesta por defecto, no es necesaria
	@ResponseBody
	public String hacercafe() {
		return "tengo café";
	}
	
	@RequestMapping("/hacerte")
	@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "¿quieres té?")
	public String hacerte() {
		return "tengo té";
	}
	
	@RequestMapping("/notfound")
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no lo he encontrao T.T")
	public String notFound() {
		return "se me perdió :(";
	}

}
