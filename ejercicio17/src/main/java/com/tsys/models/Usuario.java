package com.tsys.models;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private Long id;
	private String nombre;
	private int edad;
	private String nacionalidad;
	
	// Constructors
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, int edad, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
