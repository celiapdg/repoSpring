package com.tsys.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor 
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributes
	@Id
	private Long id;
	private String nombre;
	private Integer edad;
	private String nacionalidad;
	
}