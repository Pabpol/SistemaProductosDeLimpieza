package com.edutecno.modelo.dto;

public class CategoriaDTO {
	private double idCategoria;
	private String nombreCategoria;
	
	
	public CategoriaDTO(double idCategoria, String nombreCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
	}
	public double getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(double idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	@Override
	public String toString() {
		return "CategoriaDTO [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	

}
