package com.example.stock.dto;

public class StockStatusDto {

	private Long idProducto;
	private String estado;
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public StockStatusDto(Long idProducto, String estado) {
		super();
		this.idProducto = idProducto;
		this.estado = estado;
	}
	public StockStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
