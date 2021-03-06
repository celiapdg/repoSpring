package com.tsys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CaraOCruz {

	@RequestMapping("/cara-o-cruz")
	@ResponseBody
	public String discoteca(@RequestParam String elijo) {
		String valorGanador = Math.round(Math.random())==0?"cara":"cruz";
		if (elijo.equals(valorGanador)) return "Has ganado 🎉";
		return "Has perdido";
	}
	
}
