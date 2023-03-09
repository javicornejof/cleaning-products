package com.desafiolatam.dao;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.interfaces.CategoriaRepository;
import com.desafiolatam.interfaces.ProductoCategoriaRepo;
import com.desafiolatam.interfaces.ProductoRepository;
import com.desafiolatam.model.Categoria;
import com.desafiolatam.model.Producto;
import com.desafiolatam.dto.ProductoCategoria;

public class ProductoCategoriaDao implements ProductoCategoriaRepo{
	
	private ProductoRepository productoDao = new ProductoDao();
	private CategoriaRepository categoriaDao = new CategoriaDao();

	@Override
	public List<ProductoCategoria> listarProductosCategoria() {
		
		List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
		List<Producto> productos = productoDao.findAll();
		
		for (Producto productoTemp : productos) {
			
			ProductoCategoria productoCategoria = new ProductoCategoria();
			
			Categoria categoria = categoriaDao.buscarCategoria(productoTemp.getIdCategoria());
			productoCategoria.setProducto(productoTemp);
			productoCategoria.setCategoria(categoria); 

			
			listaProductoCategoria.add(productoCategoria);
		}
		
		return listaProductoCategoria;
	}

}
