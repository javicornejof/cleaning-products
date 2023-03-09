package com.desafiolatam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.ProductoCategoriaDao;
import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dto.ProductoCategoria;
import com.desafiolatam.interfaces.ProductoCategoriaRepo;
import com.desafiolatam.interfaces.ProductoRepository;
import com.desafiolatam.model.Producto;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/listarProducto")
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarProducto() {
        super();
       
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ProductoCategoriaRepo productoCategoriaRepo = new ProductoCategoriaDao();
		
		List<ProductoCategoria> listaProductoCategoria = productoCategoriaRepo.listarProductosCategoria();
		
		request.setAttribute("listaProductoCategoria", listaProductoCategoria);
		
		request.getRequestDispatcher("listar.jsp").forward(request, response);
		
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			doGet(req, resp);
		}



}
