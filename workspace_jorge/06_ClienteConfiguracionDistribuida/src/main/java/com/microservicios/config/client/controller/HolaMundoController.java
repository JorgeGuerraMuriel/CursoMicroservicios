package com.microservicios.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/HolaMundo")
public class HolaMundoController {

	@Value("${message}")
	private String message;
	
	@RequestMapping(path="/saludar", method=RequestMethod.GET)
	public String saludar() {
		
		return message;
	}
}
