package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.AdministradorConexion;
import com.desafiolatam.interfaces.CategoriaRepository;
import com.desafiolatam.model.Categoria;

public class CategoriaDao extends AdministradorConexion implements CategoriaRepository {
	
	private Connection conn;
	
	public CategoriaDao() {
		conn = generaConexion();
	}

	@Override
	public Categoria buscarCategoria(int id) {
		String query = "SELECT * FROM categoria WHERE id_categoria = ?";
		Categoria categoria = new Categoria();
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
			}
			
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Categoria> listarCategorias() {
		String query = "SELECT * FROM categoria";
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				listaCategorias.add(categoria);
				
			}
			
			return listaCategorias;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
