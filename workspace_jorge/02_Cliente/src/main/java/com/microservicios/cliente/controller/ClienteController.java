package com.microservicios.cliente.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.microservicios.cliente.dto.Persona;

@RestController
@RequestMapping("/HolaMundoAvanzado")
public class ClienteController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String metodo() throws RestClientException, URISyntaxException {
		
		ResponseEntity<Void> respuesta = restTemplate.postForEntity(new URI(""), new Persona(), Void.class);
		
		respuesta.getHeaders().getLocation();
		
		respuesta.getStatusCode();
		
		return null;
	}
}
