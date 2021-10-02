package com.edutecno.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;
import com.edutecno.modelo.dto.ProductoDTO;

/**
 * Servlet implementation class BuscarProducto
 */
@WebServlet("/BuscarProducto")
public class BuscarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Facade facade = new Facade();
		String idProducto = request.getParameter("idProductoBuscar");
		List<ProductoDTO> productos;
		if (idProducto != "") {
			productos = new ArrayList<>();
			ProductoDTO producto = facade.buscarProductoID(Integer.parseInt(idProducto));
			productos.add(producto);
			request.setAttribute("displayVolver", "d-inline");
			request.setAttribute("productos", productos);
			request.getServletContext().getRequestDispatcher("/inicio.jsp").forward(request, response);
		} else {

			request.getServletContext().getRequestDispatcher("/Inicio").forward(request, response);
		}


	}

}
