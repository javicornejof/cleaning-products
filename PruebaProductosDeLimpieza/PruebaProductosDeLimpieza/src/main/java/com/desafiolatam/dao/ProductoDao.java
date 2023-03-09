package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexion.AdministradorConexion;
import com.desafiolatam.interfaces.ProductoRepository;
import com.desafiolatam.model.Producto;



public class ProductoDao extends AdministradorConexion implements ProductoRepository {
	
	private Connection conn;

	public ProductoDao() {
		
		conn = generaConexion();
	}

	@Override
	public List<Producto> findAll() {
		List<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "SELECT * FROM producto";
		
		try {
			pstm = conn.prepareStatement(sql);//preparando la query a ejecuta		
			rs = pstm.executeQuery();//ejecucion de la query
			
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt("id_producto"));//el paréntesis es el nombre de columna en mysql
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				listaProductos.add(producto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}

	@Override
	public Producto findById(int id) {
		String sql = "SELECT * FROM producto WHERE id_producto =?";
		Producto producto = new Producto();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				producto.setIdProducto(rs.getInt("id_producto"));
				producto.setNombreProducto(rs.getString("nombre_producto"));
				producto.setPrecioProducto(rs.getInt("precio_producto"));
				producto.setDescripcionProducto(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
			}
			return producto;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean add(Producto producto) {
		String sql = "INSERT INTO producto VALUES (null, ?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			int result = pstm.executeUpdate();//ejecucion de la query
			
			
			if(result == 0) {
				System.out.println("Update no completado");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		System.out.println("Producto agregado correctamente");
		return true;
	}

	@Override
	public boolean update(Producto producto) {
		String sql = "UPDATE producto SET nombre_producto =?, precio_producto = ?,descripcion_producto=?, id_categoria=? WHERE id_producto =?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setInt(2, producto.getPrecioProducto());
			pstm.setString(3, producto.getDescripcionProducto());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getIdProducto());
			
			int result = pstm.executeUpdate();
			
			if (result==0) {
				System.out.println("Producto no actualizada");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Producto actualizado correctamente");
		return true;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM producto WHERE id_producto = ?";
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,  id);
			
			int result = pstm.executeUpdate();
			
			if (result ==0) {
				System.out.println("El producto no pudo ser eliminado");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Producto eliminado correctamente");
		return true;

	}
	
	

}
