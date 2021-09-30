package com.edutecno.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection conexion;
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/productos_limpieza?serverTimezone=UTC";
			String usr = "root";
			String pwd = "admin";
			conexion = DriverManager.getConnection(url, usr ,pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conexion;
		
		
	}
}
