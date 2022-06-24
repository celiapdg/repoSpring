package com.tsys.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Usuario;

@RestController
public class MainController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/")
	public String prueba() {
		return "Hola";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Usuario> getAllUsers(){
		final String QUERY = "SELECT * FROM usuarios;";
		
		// Guardamos el resultado de la query
		List<Map<String,Object>> results = jdbcTemplate.queryForList(QUERY);
		
		List<Usuario> userList = new ArrayList<Usuario>();
		
		for (Map<String, Object> row: results) {
			Usuario user = new Usuario();
			
			user.setId((Long) row.get("id_usuarios"));
			user.setNombre((String) row.get("nombre"));
			user.setEdad((int) row.get("edad"));
			user.setNacionalidad((String) row.get("nacionalidad"));
			
			userList.add(user);
		}
		return userList;
	}
	
	@PutMapping("/users/{id}")
	public String modifyUser(@PathVariable int id) { // RequestBody Usuario con id, nombre, edad, pais
		return "";
	}
	
}
