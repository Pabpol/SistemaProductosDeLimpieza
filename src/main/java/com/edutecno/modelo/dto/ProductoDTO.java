package com.edutecno.modelo.dto;

public class ProductoDTO {
	
private double idProducto;
private String nombreProdcuto;
private double precioProducto;
private String descripcionProducto;
private CategoriaDTO categoria;

public double getIdProducto() {
	return idProducto;
}
public void setIdProducto(double idProducto) {
	this.idProducto = idProducto;
}
public String getNombreProdcuto() {
	return nombreProdcuto;
}
public void setNombreProdcuto(String nombreProdcuto) {
	this.nombreProdcuto = nombreProdcuto;
}
public double getPrecioProducto() {
	return precioProducto;
}
public void setPrecioProducto(double precioProducto) {
	this.precioProducto = precioProducto;
}
public String getDescripcionProducto() {
	return descripcionProducto;
}
public void setDescripcionProducto(String descripcionProducto) {
	this.descripcionProducto = descripcionProducto;
}
public CategoriaDTO getCategoria() {
	return categoria;
}
public void setCategoria(CategoriaDTO categoria) {
	this.categoria = categoria;
}
@Override
public String toString() {
	return "ProductoDTO [idProducto=" + idProducto + ", nombreProdcuto=" + nombreProdcuto + ", precioProducto="
			+ precioProducto + ", descripcionProducto=" + descripcionProducto + ", categoria=" + categoria + "]";
}





}
