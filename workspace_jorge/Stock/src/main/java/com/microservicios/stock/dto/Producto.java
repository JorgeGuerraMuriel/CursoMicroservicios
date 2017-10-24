package com.microservicios.stock.dto;

public class Producto {

	private String code;
	private int cantidad;
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public int getCantidad() {
		return cantidad;
	}
}
