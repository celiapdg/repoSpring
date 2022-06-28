package com.tsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Director;
import com.tsys.repositories.DirectorRepository;

@RestController
public class DirectorController {

	@Autowired
	DirectorRepository directorRepository;
	
	@GetMapping("/director/{id}") @CrossOrigin
	public Director getDirector(@PathVariable Integer id) {
		return directorRepository.findById(id).get();
	}
}
