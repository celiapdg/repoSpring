package com.tsys.controllers;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Persona;

import ch.qos.logback.classic.Logger;

@RestController
public class MainController {
	
	ArrayList<Persona> personas = new ArrayList<Persona>();
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/yo")
	public Persona getPersona() {
		LOGGER.info("Me muestro en pantalla");
		return new Persona("Celia", "Lumbreras", 26);
	}
	
	@PostMapping("/newpersona")
	public Persona postPersona(@RequestBody Persona persona) {
		personas.add(persona);
		LOGGER.info("Nueva persona añadida");
		return persona;
	}
	
	@DeleteMapping("/killpersona/{id}")
	public String deletePersona(@PathVariable int id) {
		personas.remove(id);
		LOGGER.info("Persona con id = "+id+" eliminada");
		return "Persona con id = "+id+" eliminada";
	}
	
	
	
}
