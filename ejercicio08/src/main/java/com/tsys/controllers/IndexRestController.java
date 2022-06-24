package com.tsys.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.models.Car;

@RestController
public class IndexRestController {
	
	@RequestMapping("/json2")
	public Car json2() {
		return new Car();
	}

}
