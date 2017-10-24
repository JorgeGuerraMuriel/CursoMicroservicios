package com.example.web.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.dto.Persona;

@RestController
@RequestMapping("/Persona")
public class PersonaController {

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Persona persona) throws URISyntaxException {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8280/api/Persona/" + persona.getId()));
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> baja(@PathVariable Long id) {
		return null;
	}

	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> modificar(@PathVariable Long id, @RequestBody Persona persona) {
		return null;
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> consultar(@PathVariable Long id) {
		return new ResponseEntity<Persona>(new Persona(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> consultar() {
		return null;
	}

}
