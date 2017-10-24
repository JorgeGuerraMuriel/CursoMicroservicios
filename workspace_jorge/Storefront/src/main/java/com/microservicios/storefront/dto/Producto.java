package com.microservicios.storefront.dto;

public class Producto {

	private String code;
	private int cantidad;
	
	public Producto(String code, int cantidad) {
		this.code = code;
		this.cantidad = cantidad;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
}
