package com.tsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Genre;
import com.tsys.repositories.GenreRepository;

@RestController
public class GenreController {
	
	@Autowired
	GenreRepository genreRepository;
	
	@GetMapping("/genre/{id}") @CrossOrigin
	public Genre getGenre(@PathVariable Integer id) {
		return genreRepository.findById(id).get();
	}
}
