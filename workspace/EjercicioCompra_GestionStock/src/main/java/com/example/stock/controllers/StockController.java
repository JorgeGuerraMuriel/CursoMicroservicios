package com.example.stock.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.stock.dto.StockStatusDto;

@RestController
public class StockController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/decrementarStockProducto/{idProducto}/{cantidad}", method=RequestMethod.GET)
	public ResponseEntity<Void> decrementarStockProducto(@PathVariable Long idProducto, @PathVariable Integer cantidad) {
		System.out.println("Decrementando el producto: " + idProducto + " en " + cantidad + " unidades");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(path="/revisarStockProducto/{idProducto}", method=RequestMethod.GET)
	public ResponseEntity<StockStatusDto> revisarStockProducto(@PathVariable Long idProducto) throws RestClientException, URISyntaxException {
		
		//Realizar pedido al proveedor con el servicio de notificaciones
		ResponseEntity<Void> respuesta = restTemplate.getForEntity(new URI("http://localhost:8680/notificarProveedor/1?tipoNotificacion=loquesea"), Void.class);
		
		System.out.println("Codigo de respuesta de Notificacion: " + respuesta.getStatusCode());
		
		return new ResponseEntity<StockStatusDto>(
				new StockStatusDto(idProducto, "Relizado pedido de reabastecimiento"), 
				HttpStatus.OK);
	}

}
