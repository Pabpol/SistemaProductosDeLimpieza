package com.edutecno.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/productos_limpieza?serverTimezone=UTC";
	private final String USR = "root";
	private final String PWD = "admin";
	
	private static Conexion conexion = null;
	private BasicDataSource poolConexiones; 
	
	private Conexion() {
		poolConexiones = new BasicDataSource();
		poolConexiones.setDriverClassName(DRIVER);
		poolConexiones.setUsername(USR);
		poolConexiones.setUrl(URL);
		poolConexiones.setPassword(PWD);
		
	}
	
	public static Conexion getConexion() {
		if (conexion == null) {
			conexion = new Conexion();
			
		}
		return conexion;
		
		
	}
	
	public Connection getCnn() throws SQLException {
		return poolConexiones.getConnection();
	}
	

}
