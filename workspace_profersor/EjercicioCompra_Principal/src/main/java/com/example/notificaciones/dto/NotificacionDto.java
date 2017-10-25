package com.example.notificaciones.dto;

public class NotificacionDto {

	private long id;
	private String tipoNotificacion;
	
	public NotificacionDto(long id, String tipoNotificacion) {
		super();
		this.id = id;
		this.tipoNotificacion = tipoNotificacion;
	}
	public NotificacionDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}
	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}
}
