package com.example.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HolaMundo")
public class HolaMundoController {

	@RequestMapping(path="/Saludar", method=RequestMethod.GET)
	public String metodo(@RequestParam String nombre){
		return "Hola " + nombre;
	}
	
	
}
