package com.example.notificaciones.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificacionesController {

	// http:..../notificarUsuario/{idUsuario}?tipoNotificacion=loquesea
	@RequestMapping(path="/notificarUsuario/{idUsuario}", method=RequestMethod.GET)
	public void enviarNotificacionUsuario(@PathVariable Long idUsuario, @RequestParam String tipoNotificacion){
		System.out.println("Notificar usuario: " + idUsuario + " una notificacion de tipo: " + tipoNotificacion);
	}
	
	// http:..../notificarProveedor/{idProveedor}?tipoNotificacion=loquesea
	@RequestMapping(path="/notificarProveedor/{idProveedor}", method=RequestMethod.GET)
	public void enviarNotificacionProveedor(@PathVariable Long idProveedor, @RequestParam String tipoNotificacion){
		System.out.println("Notificar proveedor: " + idProveedor + " una notificacion de tipo: " + tipoNotificacion);
	}
	
}
