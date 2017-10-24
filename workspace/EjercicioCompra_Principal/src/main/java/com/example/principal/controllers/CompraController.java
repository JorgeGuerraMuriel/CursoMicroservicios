package com.example.principal.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

// Servicio JSON, la compra no la considero un recurso
// Servicio de orquestacion

@RestController
public class CompraController {

	// Necesario para aproximacion monolitica
	// @Autowired
	// private ServicioStock servicioStock;
	// @Autowired
	// private ServicioNotificaciones servicioNotificaciones;

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@RequestMapping("/compra")
	public void lanzarCompraProducto() throws RestClientException, URISyntaxException {

		// Necesario para aproximacion monolitica
		// Actualizar el Stock
		// servicioStock.decrementarStockDeProducto(idProducto,
		// cantidadARestar);

		// Notificar al usuario
		// servicioNotificaciones.notificarCompraEnProcesoAUsuario(idProducto,
		// IdUsuario);

		// Revisar Stock
		// servicioStock.revisarStockDeProducto(idProducto);

		// Aproximacion microservicios
		// Actualizar el Stock
		ResponseEntity<Void> respuestaActualizarStock = restTemplate
				.getForEntity(
						new URI(
								"http://localhost:8480/decrementarStockProducto/1/10"),
						Void.class);

		System.out.println("Codigo de respuesta de ActualizarStock: "
				+ respuestaActualizarStock.getStatusCode());
		// Notificar al usuario
		ResponseEntity<Void> respuestaNotificarUsuario = restTemplate
				.getForEntity(
						new URI(
								"http://localhost:8680/notificarUsuario/1?tipoNotificacion=loquesea"),
						Void.class);

		System.out.println("Codigo de respuesta de NotificarUsuario: "
				+ respuestaNotificarUsuario.getStatusCode());
		// Revisar Stock
		ResponseEntity<Void> respuestaRevisarStock = restTemplate
				.getForEntity(
						new URI(
								"http://localhost:8480/revisarStockProducto/1"),
						Void.class);

		System.out.println("Codigo de respuesta de RevisarStock: "
				+ respuestaRevisarStock.getStatusCode());
	}

}
