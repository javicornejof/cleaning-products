package com.desafiolatam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.CategoriaDao;
import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.interfaces.CategoriaRepository;
import com.desafiolatam.interfaces.ProductoRepository;
import com.desafiolatam.model.Categoria;
import com.desafiolatam.model.Producto;

/**
 * Servlet implementation class AgregarProducto
 */
@WebServlet("/agregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoriaRepository categoriaRepo = new CategoriaDao();
	ProductoRepository productoRepo = new ProductoDao();
	
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Categoria> listaCategorias = categoriaRepo.listarCategorias();
			
			request.setAttribute("categorias", listaCategorias);
			
			
			request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
		
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int precio =  Integer.parseInt(request.getParameter("precio"));
		
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		
		Producto producto = new Producto();
		producto.setIdProducto(0);
		producto.setNombreProducto(nombre);
		producto.setDescripcionProducto(descripcion);
		producto.setPrecioProducto(precio);
		producto.setIdCategoria(categoria);
		
		System.out.println(producto);
		
		if (productoRepo.add(producto)) {
			
			
			request.getRequestDispatcher("listarProducto").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
		
	}
	

}
