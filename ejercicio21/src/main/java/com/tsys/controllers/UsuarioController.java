package com.tsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Usuario;

@RestController
@RequestMapping("/v1.0")
public class UsuarioController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// recursos
	// https://www.netjstech.com/2016/11/insert-update-using-jdbctemplate-in-spring-framework.html
	// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcOperations.html#query-java.lang.String-org.springframework.jdbc.core.RowMapper-java.lang.Object...-

	@GetMapping("/usuario/{id}")
	public Usuario muestraUsuario(@PathVariable Long id) {
		final String QUERY = "SELECT * FROM usuarios WHERE id=?;";
		return (Usuario) jdbcTemplate.queryForObject(QUERY, new BeanPropertyRowMapper(Usuario.class), id);
	}

	@PostMapping("/usuario/nuevo")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario nuevoUsuario(Usuario usuario) {
		final String QUERY = "INSERT INTO usuarios(nombre, edad, nacionalidad) VALUES (?, ? ,?);";

		jdbcTemplate.update(QUERY, usuario.getNombre(), usuario.getEdad(), usuario.getNacionalidad());
		return usuario;
	}

	@DeleteMapping("/usuario/borra/{id}")
	public void borraUsuario(@PathVariable Long id) {
		final String QUERY = "DELETE FROM usuarios WHERE id=?;";
		
		int status = jdbcTemplate.update(QUERY, id);
		if(status != 0){
	    	System.out.println("Usuario borrado con id: " + id);
	    }else{
	    	System.out.println("No se ha encontrado el usuario con id: " + id);
	    }
	}
	
	@PatchMapping("/usuario/actualiza")
	public Usuario cambiaUsuario(@RequestBody Usuario usuario) {
		final String QUERY = "UPDATE usuarios SET nombre = ?, edad = ?, nacionalidad = ? WHERE id=?;";
		
		jdbcTemplate.update(QUERY, usuario.getNombre(), usuario.getEdad(), usuario.getNacionalidad(), usuario.getId());
		return usuario;
	}
	
	
}
