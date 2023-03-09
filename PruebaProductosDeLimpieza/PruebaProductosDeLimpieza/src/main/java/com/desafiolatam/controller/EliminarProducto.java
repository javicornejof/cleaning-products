package com.desafiolatam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.interfaces.ProductoRepository;

@WebServlet("/eliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoRepository productoRepo;

	public EliminarProducto() {
		this.productoRepo=  new ProductoDao();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id_producto");

		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		request.setAttribute("id", idParam);
		request.getRequestDispatcher("EliminarProducto.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id_producto");
		int id = 0;

		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		id = Integer.parseInt(idParam);
		productoRepo.delete(id);

		request.getRequestDispatcher("listarProducto").forward(request, response);

	}

}
