package com.microservicios.stock.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.microservicios.stock.dto.Producto;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	private static final int STOCK_MINIMO = 5;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(path="/decrementarStock", method=RequestMethod.POST)
	public ResponseEntity<Void> decrementarStock(@RequestBody Producto producto) {

		//TODO: Llamada a la BBDD para actualizar el Stocks
		System.out.println("Decrementar Stock del Product: " + producto.getCode() + " en: " + producto.getCantidad() + " unidades");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path="/revisarStock", method=RequestMethod.POST)
	public ResponseEntity<Void> revisarStock(@RequestBody Producto producto) throws RestClientException, URISyntaxException {

		//TODO: Llamada a la BBDD para recuperar el Stocks
		System.out.println("Comprobar Stock Disponible del Product: " + producto.getCode());
		int stockAcutal = 2;
		
		//Comprobar el stock y si es insuficiente incrementarlo
		if (STOCK_MINIMO > stockAcutal) {
			System.out.println("Incrementar Stock del Producto: " + producto.getCode());
			restTemplate.getForEntity(new URI("http://localhost:9004/notificacion/enviarNotificacionProveedor/" + producto.getCode()), Void.class);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
