package com.tsys.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@NoArgsConstructor
public class User2 {
	private static final long serialVersionUID = 1L;
	// Atributes
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String surname;
}
