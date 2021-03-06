package com.tsys.controllers;

import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

@Controller
public class ParamsController {

	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(ParamsController.class);
	
	@RequestMapping("/")
	@ResponseBody
	public String saludaNombre(@RequestParam(required = false, defaultValue = "desconocido") String nombre,
			@RequestParam(required = false, defaultValue = "") String apellido) {
		return "Bienvenid@ " + nombre + " " + apellido;
	}


	@RequestMapping(path = "/json", produces="application/json")
	@ResponseBody
	public String saludaNombreJson(@RequestParam(required = false, defaultValue = "desconocido") String nombre,
			@RequestParam(required = false, defaultValue = "desconocidos") String apellido) {
		return "{\"nombre\": \""+nombre+"\", \"apellidos\": \""+apellido+"\"}";
	}
	
	@RequestMapping("/inf")
	@ResponseBody
	public String infParams(@RequestParam(required = false) Map<String,String> allParams) {
		if (allParams.isEmpty()) {
			return "No has introducido ningún parámetro!!";
		}
		
		String result = "";
		
		for (String key: allParams.keySet()) {
			LOGGER.info(key + ": "+allParams.get(key));
			result = result.concat(key+": "+allParams.get(key)+"\n");
		}
		
		return result;
	}

}
