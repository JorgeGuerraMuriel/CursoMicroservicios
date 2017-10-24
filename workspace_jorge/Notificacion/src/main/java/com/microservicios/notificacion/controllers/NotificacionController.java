package com.microservicios.notificacion.controllers;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservicios.notificacion.dto.Cliente;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path="/enviarNotificacionCliente", method=RequestMethod.POST)
	public ResponseEntity<String> enviarNotificacionCliente(@RequestBody Cliente cliente) throws URISyntaxException {
		
		//TODO: Llamada al servicio de mensajería
		System.out.println("Notificar Usuario: " + cliente.getNombre());
		
		return new ResponseEntity<String>("Pedido se ha procesado", HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/enviarNotificacionProveedor/{code}", method=RequestMethod.GET)
	public ResponseEntity<Void> enviarNotificacionProveedor(@PathVariable String code) throws URISyntaxException {
		
		//TODO: Llamada al servicio de mensajería
		System.out.println("Notificar Proveedor Incrementar Stock Product: " + code);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
