package com.tsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostMapping("/usuario/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario nuevoUsuario(Usuario usuario) {
		final String QUERY = "INSERT INTO usuarios(nombre, edad, nacionalidad) VALUES (?, ? ,?);";

		jdbcTemplate.update(QUERY, usuario.getNombre(), usuario.getEdad(), usuario.getNacionalidad());
		return usuario;
	}
	
}
