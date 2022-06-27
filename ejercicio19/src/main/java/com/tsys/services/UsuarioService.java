package com.tsys.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsys.models.Usuario;
import com.tsys.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> usuarioById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario nuevoUsuario(Usuario usuario) {
		if ((usuario.getNombre()!=""&&usuario.getNombre()!=null)&&
		   (usuario.getEdad()>=0&&usuario.getEdad()!=null)&&
		   (usuario.getNacionalidad()!=""&&usuario.getNacionalidad()!=null)){
			return usuarioRepository.save(usuario);
		}else return null;
	}
	
	public Usuario actualizarUsuario(Usuario usuario, Long id) {
		Usuario nuevoUsuario = usuarioRepository.findById(id).get();
		
		if (usuario.getNombre()!=null) nuevoUsuario.setNombre(usuario.getNombre());
		if (usuario.getEdad()!=null) nuevoUsuario.setEdad(usuario.getEdad());
		if (usuario.getNacionalidad()!=null) nuevoUsuario.setNacionalidad(usuario.getNacionalidad());
		nuevoUsuario.setId(id);
		
		usuarioRepository.save(nuevoUsuario);
		
		return nuevoUsuario;
	}
	
	public void borrarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
}
