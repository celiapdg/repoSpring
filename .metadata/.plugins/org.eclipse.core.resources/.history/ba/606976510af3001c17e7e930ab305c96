package com.tsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Discoteca {
	
	@RequestMapping("/discoteca")
	@ResponseBody
	public String discoteca(@RequestParam int edad) {
		if (edad>=18) return "Puedes pasar";
		return "NO PUEDES PASAR (y Gandalf lo sabe)";
	}

}
