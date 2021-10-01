package com.edutecno.facade;

import java.util.List;

import com.edutecno.modelo.dao.ProductoDAO;
import com.edutecno.modelo.dto.ProductoDTO;

public class Facade {
	
	ProductoDAO producto = new ProductoDAO();
	
	public List<ProductoDTO> listarProductos(){
		return producto.listar();
	}
	public ProductoDTO buscarProductoID(Double id) {
		return producto.buscarPorId(id);
	}
	public int insertarProducto(ProductoDTO prod) {
		return producto.insert(prod);
	}
	public int updateProducto(ProductoDTO prod) {
		return producto.update(prod);
	}
	public int deleteProducto(Double id) {
		return producto.delete(id);
	}
	

}
