package com.edutecno.modelo.dto;

public class ProductoDTO {
	
private int idProducto;
private String nombreProdcuto;
private int precioProducto;
private String descripcionProducto;
private CategoriaDTO categoria;

public int getIdProducto() {
	return idProducto;
}
public void setIdProducto(int idProducto) {
	this.idProducto = idProducto;
}
public String getNombreProdcuto() {
	return nombreProdcuto;
}
public void setNombreProdcuto(String nombreProdcuto) {
	this.nombreProdcuto = nombreProdcuto;
}
public int getPrecioProducto() {
	return precioProducto;
}
public void setPrecioProducto(int precioProducto) {
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
