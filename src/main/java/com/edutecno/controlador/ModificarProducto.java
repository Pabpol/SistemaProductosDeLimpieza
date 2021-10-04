package com.edutecno.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edutecno.facade.Facade;
import com.edutecno.modelo.dto.CategoriaDTO;
import com.edutecno.modelo.dto.ProductoDTO;

/**
 * Servlet implementation class ModificarProducto
 */
@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idCategoria = 0;
		Facade facade = new Facade();
		ProductoDTO producto = new ProductoDTO();
		CategoriaDTO categoria = new CategoriaDTO();
		producto.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
		producto.setNombreProdcuto(request.getParameter("nombreProducto"));
		producto.setPrecioProducto(Integer.parseInt(request.getParameter("precio")));
		producto.setDescripcionProducto(request.getParameter("descripcion"));
		String nombreCategoria = request.getParameter("categoria");
		if (nombreCategoria.equals("Detergente líquido")) {
			idCategoria = 1;
		}else if(nombreCategoria.equals("Detergente en polvo")) {
			idCategoria = 2;
		}
		categoria.setIdCategoria(idCategoria);
		categoria.setNombreCategoria(nombreCategoria);
		producto.setCategoria(categoria);
		
		facade.updateProducto(producto) ;

		request.getServletContext().getRequestDispatcher("/EntrarSistema").forward(request, response);
	}

}
