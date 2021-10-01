package com.edutecno.pruebaMain;



import com.edutecno.facade.Facade;
import com.edutecno.modelo.dto.CategoriaDTO;
import com.edutecno.modelo.dto.ProductoDTO;

public class MainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 1;
		Facade facade = new Facade();
		ProductoDTO producto = new ProductoDTO();
//		producto.setIdProducto(3.0);
		producto.setNombreProdcuto("Drive");
		producto.setPrecioProducto(2500.0);
		producto.setDescripcionProducto("no lo se");
		producto.setCategoria(new CategoriaDTO(1.0, "detergente_liquido"));
		System.out.println(facade.insertarProducto(producto));
//		System.out.println(facade.updateProducto(producto));
//		System.out.println(facade.deleteProducto(3.0));
		System.out.println(facade.listarProductos());
		

	}

}
