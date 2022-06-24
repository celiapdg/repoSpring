package com.tsys.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private static final long serialVersionUID = 1L;
	// Atributes
	private Long id;
	private String name;
	private String surname;
}
