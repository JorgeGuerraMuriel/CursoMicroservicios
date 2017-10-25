package com.example.notificaciones.controllers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.notificaciones.dto.NotificacionDto;

//@RestController
@Component
public class NotificacionesController {

	// http:..../notificarUsuario/{idUsuario}?tipoNotificacion=loquesea
	//@RequestMapping(path="/notificarUsuario/{idUsuario}", method=RequestMethod.GET)
	@JmsListener(destination = "Usuarios", containerFactory = "myFactory")
	public void enviarNotificacionUsuario(NotificacionDto notificacion){
		System.out.println("Notificar usuario: " + notificacion.getId() + " una notificacion de tipo: " + notificacion.getTipoNotificacion());
	}
	
	// http:..../notificarProveedor/{idProveedor}?tipoNotificacion=loquesea
	//@RequestMapping(path="/notificarProveedor/{idProveedor}", method=RequestMethod.GET)
	@JmsListener(destination = "Proveedores", containerFactory = "myFactory")
	public void enviarNotificacionProveedor(NotificacionDto notificacion){
		System.out.println("Notificar proveedor: " + notificacion.getId() + " una notificacion de tipo: " + notificacion.getTipoNotificacion());
	}
	
}
