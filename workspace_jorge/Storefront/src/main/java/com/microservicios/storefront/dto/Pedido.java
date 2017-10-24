package com.microservicios.storefront.dto;

public class Pedido {
	
	private int id;
	private Cliente cliente;
	private Producto producto;

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
}
