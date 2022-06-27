package com.tsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsys.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
