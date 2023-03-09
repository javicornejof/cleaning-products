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


@WebServlet("/modificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductoRepository productoRepo = new ProductoDao();
	CategoriaRepository categoriaRepo = new CategoriaDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id_producto"));
		
		if (id <= 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		Producto producto = productoRepo.findById(id);
		
		if (producto.getIdProducto() == 0) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		List<Categoria> categorias = categoriaRepo.listarCategorias();
		request.setAttribute("categorias", categorias);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id_producto"));
		String nombre = request.getParameter("nombre_producto");
		int precio = Integer.parseInt(request.getParameter("precio_producto"));
		String descripcion = request.getParameter("descripcion_producto");
		int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
		
		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		Producto producto = new Producto();
		producto.setIdProducto(id);
		producto.setNombreProducto(nombre);
		producto.setPrecioProducto(precio);
		producto.setDescripcionProducto(descripcion);
		producto.setIdCategoria(idCategoria);
		
		productoRepo.update(producto);
		
		request.getRequestDispatcher("listarProducto").forward(request, response);
		
		
	}

}
