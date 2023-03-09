package com.desafiolatam.interfaces;

import java.util.List;

import com.desafiolatam.model.Categoria;

public interface CategoriaRepository {
	
	public Categoria buscarCategoria(int id);
	public List<Categoria> listarCategorias();

}
