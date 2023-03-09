package com.desafiolatam.interfaces;

import java.util.List;

import com.desafiolatam.model.Producto;


public interface ProductoRepository {
	
	public List<Producto> findAll();
	
	public Producto findById(int id);
	
	public boolean add(Producto producto);
	
	public boolean update(Producto producto);
	
	public boolean delete(int id);

}
