package com.tsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsys.models.Car;

@Controller
public class IndexController {
	
	@RequestMapping("/hola")
	public String saludo() {
		return "index.html";
	}
	
	@RequestMapping("/json1")
	@ResponseBody
	public Car json1() {
		Car car = new Car();
		car.color = "green";
		return car;
	}

}
