package com.edutecno.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edutecno.conexion.Conexion;
import com.edutecno.modelo.dto.CategoriaDTO;
import com.edutecno.modelo.dto.ProductoDTO;

public class ProductoDAO implements DAO<ProductoDTO, Integer> {

	@Override
	public List<ProductoDTO> listar() {
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>();
		Connection conexion = null;

		String consultaSQL = "SELECT id_producto, nombre_producto, precio_producto, descripcion_producto, p.id_categoria, nombre_categoria from producto p inner join categoria c on p.id_categoria = c.id_categoria;";

		try {
			conexion = Conexion.getConnection();
			PreparedStatement ps = conexion.prepareStatement(consultaSQL);
			ResultSet rs = ps.executeQuery();
			ProductoDTO producto = new ProductoDTO();
			producto.setIdProducto(rs.getInt("id_producto"));
			producto.setNombreProdcuto(rs.getString("nombre_producto"));
			producto.setPrecioProducto(rs.getInt("precio_producto"));
			producto.setDescripcionProducto(rs.getString("descripcion_producto"));
			producto.setCategoria(new CategoriaDTO(rs.getInt("id_categoria"), rs.getString("nombre_categoria")));
			productos.add(producto);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productos;
	}

	@Override
	public ProductoDTO buscarPorId(Integer id) {
		ProductoDTO producto = new ProductoDTO();
		Connection conexion = null;

		String consultaSQL = "SELECT id_producto, nombre_producto, precio_producto, descripcion_producto, p.id_categoria, nombre_categoria from producto p inner join categoria c on p.id_categoria = c.id_categoria WHERE c.id_categoria = ?;";

		try {
			conexion = Conexion.getConnection();
			PreparedStatement ps = conexion.prepareStatement(consultaSQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProdcuto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setCategoria(new CategoriaDTO(rs.getInt("id_categoria"), rs.getString("nombre_categoria")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return producto;

	}

	@Override
	public int insert(ProductoDTO objetos) {
		int max = 0;
		Connection conexion = null;
		int registrosAfectados = 0;
		String consultaProximoId = " SELECT MAX(id_producto)+1 FROM producto";
		String consultaSQL = "INSERT INTO producto(id_producto, nombre_producto, precio_producto, descripcion_producto, id_categoria) VALUES(?,?,?,?)";
		
		try {
			conexion = Conexion.getConnection();
			PreparedStatement ps = conexion.prepareStatement(consultaProximoId);
			ResultSet rs = conexion.prepareStatement(consultaSQL).executeQuery();
			if (rs.next()) {
				 max = rs.getInt(1);
					ps.setInt(1, max);
					ps.setString(2, objetos.getNombreProdcuto());
					ps.setInt(3, objetos.getPrecioProducto());
					ps.setString(4, objetos.getDescripcionProducto());
					ps.setInt(5, objetos.getCategoria().getIdCategoria());
					registrosAfectados = ps.executeUpdate();
					
					if (registrosAfectados != 1) {
						throw new RuntimeException("A ocurrido un error inesperado");
					}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return registrosAfectados;
	}

	@Override
	public int update(ProductoDTO objeto) {
		
		Connection conexion = null;
		int registrosAfectados = 0;
		String consultaSQL = "UPDATE producto SET nombre_producto = ?, precio_producto = ?, descripcion_producto = ?, id_categoria = ?, WHERE id_producto = ?;";
		try {
			conexion = Conexion.getConnection();
			PreparedStatement ps = conexion.prepareStatement(consultaSQL);
			ps.setString(1, objeto.getNombreProdcuto());
			ps.setInt(2, objeto.getPrecioProducto());
			ps.setString(3, objeto.getDescripcionProducto());
			ps.setInt(4, objeto.getCategoria().getIdCategoria());
			ps.setInt(5, objeto.getIdProducto());
			registrosAfectados = ps.executeUpdate();
			if(registrosAfectados != 1) {
				throw new Exception("Error al actualizar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrosAfectados;
		
	}

	@Override
	public int delete(Integer id) {
		Connection conexion = null;
		int registrosAfectados = 0;
		String consultaSQL = "DELETE FROM producto WHERE id_producto = ?;";
		try {
			conexion = Conexion.getConnection();
			PreparedStatement ps = conexion.prepareStatement(consultaSQL);
			ps.setInt(1, id);
			registrosAfectados = ps.executeUpdate();
			if(registrosAfectados != 1) {
				throw new Exception("Error al eliminar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrosAfectados;
	
	}

}