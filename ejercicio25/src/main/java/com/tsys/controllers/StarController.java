package com.tsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Star;
import com.tsys.repositories.StarRepository;

@RestController
public class StarController {

	@Autowired
	StarRepository starRepository;
	
	@GetMapping("/star/{id}") @CrossOrigin
	public Star getStar(@PathVariable Integer id) {
		return starRepository.findById(id).get();
	}
}
