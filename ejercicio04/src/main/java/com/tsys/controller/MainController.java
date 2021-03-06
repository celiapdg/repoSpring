package com.tsys.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tsys.model.Car;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "index.html";
	}
	
	@RequestMapping(path="/index2", produces="application/json")
	@ResponseBody
	public String showIndexJson() {
		return "{\"page\": \"index.html\"}";
	}
	
	@RequestMapping(path = "/a", produces="application/json")
	@ResponseBody
	public String showA() {
		return "{\"letra\": \"A\"}";
	}
	
	@RequestMapping("/car")
	@ResponseBody
	public Car showCar() {
		return new Car();
	}
	
	@RequestMapping("/object")
	@ResponseBody
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public ObjectNode showObject() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("string", "cadena");
		node.put("int", 64);
		node.put("float", 3.14f);
		node.put("bool", false);
		return node;
	}
	
	@RequestMapping("/entity")
	@ResponseBody
	public ResponseEntity<Car> showEntity() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		Car car = new Car();
		car.color = "red";
		return new ResponseEntity<Car>(car, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping("/entitystr")
	@ResponseBody
	
	public ResponseEntity<String> showEntityStr() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		int random = (int) Math.round(Math.random());
		if (random == 0) {
			return new ResponseEntity<String>("{\"letra\": \"X\"}", httpHeaders, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		}
		return new ResponseEntity<String>("{\"letra\": \"Z\"}", httpHeaders, HttpStatus.I_AM_A_TEAPOT);
	}

}
