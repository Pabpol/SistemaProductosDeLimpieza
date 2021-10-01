package com.edutecno.pruebaMain;

import java.sql.Date;

import com.edutecno.facade.Facade;

import com.edutecno.modelo.dto.ProductoDTO;

public class MainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i = 1;
		Facade facade = new Facade();
		ProductoDTO producto = new ProductoDTO();
		System.out.println(facade.buscarProductoID(i));

	}

}
