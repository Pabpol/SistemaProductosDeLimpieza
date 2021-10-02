package com.edutecno.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;

import com.edutecno.facade.Facade;
import com.edutecno.modelo.dto.CategoriaDTO;
import com.edutecno.modelo.dto.ProductoDTO;

/**
 * Servlet implementation class AgregarProducto
 */
@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idCategoria = 0;
		Facade facade = new Facade();
		ProductoDTO producto = new ProductoDTO();
		String nombreProducto = request.getParameter("nombreProducto");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		String nombreCategoria = request.getParameter("categoria");
		if (nombreCategoria.equals("Detergente líquido")) {
			idCategoria = 1;
		}else if(nombreCategoria.equals("Detergente en polvo")) {
			idCategoria = 2;
		}
		producto.setNombreProdcuto(nombreProducto);
		producto.setPrecioProducto(precio);
		producto.setDescripcionProducto(descripcion);
		producto.setCategoria(new CategoriaDTO(idCategoria, nombreCategoria));
		facade.insertarProducto(producto);
		request.getServletContext().getRequestDispatcher("/Inicio").forward(request, response);
		
		
		
	}

}
