package com.microservicios.storefront.controllers;

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

import com.microservicios.storefront.dto.Cliente;
import com.microservicios.storefront.dto.Pedido;
import com.microservicios.storefront.dto.Producto;

/**
 * Servicio JSON
 * Sercicio de Orquestación
 * @author Jorge
 *
 */

@RestController
@RequestMapping("/pedido")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/crear/{code}", method=RequestMethod.GET)
	public String sendOrder(@PathVariable int code) throws RestClientException, URISyntaxException {
		
		Pedido pedido = new Pedido();
		pedido.setId(code);
		
		Cliente cliente = new Cliente("Pepito");
		pedido.setCliente(cliente);
		
		Producto producto = new Producto("ABC1234", 1);
		pedido.setProducto(producto);
		
		ResponseEntity<Void> respuestaStock = restTemplate.postForEntity(new URI("http://localhost:9003/stock/decrementarStock"), pedido.getProducto(), Void.class);
		
		restTemplate.postForEntity(new URI("http://localhost:9003/stock/revisarStock"), pedido.getProducto(), Void.class);
		
		HttpStatus status = respuestaStock.getStatusCode();
		
		if (status.is2xxSuccessful()) {
			
			ResponseEntity<String> respuestaEnvio = restTemplate.postForEntity(new URI("http://localhost:9004/notificacion/enviarNotificacionCliente"), pedido.getCliente(), String.class);
			
			return respuestaEnvio.getBody();
		}
		
		return "Envío no procesado";
	}
}
