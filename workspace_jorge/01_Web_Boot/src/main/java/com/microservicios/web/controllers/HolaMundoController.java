package com.microservicios.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/HolaMundo")
public class HolaMundoController {

	@RequestMapping(path="/Saludar", method=RequestMethod.GET)
	@ResponseBody
	public String metodo(@RequestParam String nombre) {
		return "Hola " + nombre;
	}
}
