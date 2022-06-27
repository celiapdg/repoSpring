package com.tsys.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Usuario;
import com.tsys.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(path = "/users/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<Usuario> usuarioById(@PathVariable Long id) {
		Optional<Usuario> opt = usuarioService.usuarioById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Usuario>(opt.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/users/add")
	public ResponseEntity<Usuario> nuevoUsuario(@RequestBody Usuario usuario){
		Usuario nuevoUsuario = usuarioService.nuevoUsuario(usuario);
		if (nuevoUsuario != null) return new ResponseEntity<Usuario>(nuevoUsuario, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PatchMapping("/users/update/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(Usuario usuario, @PathVariable Long id) {
		Usuario nuevoUsuario = new Usuario();
		try {
			nuevoUsuario = usuarioService.actualizarUsuario(nuevoUsuario, id);
			return new ResponseEntity<Usuario>(nuevoUsuario, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<String> borrarUsuario(@PathVariable Long id) {
		try {
			usuarioService.borrarUsuario(id);
			return new ResponseEntity<>("Usuario borrado con éxito", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
