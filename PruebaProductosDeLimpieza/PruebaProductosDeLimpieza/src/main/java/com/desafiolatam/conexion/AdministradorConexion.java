package com.desafiolatam.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorConexion {
	
	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	
	//EJEMPLO DE CONEXION SIN SINGLETON
	protected Connection generaConexion() {
		String user = "admin";
		String password = "1234";
		String baseDeDatos = "productos_limpieza";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/empresa";
		
		if (conn==null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection("jdbc:mysql://localhost/"+baseDeDatos+"?user="+user+"&password="+password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Conexión establecida");
			return conn;
		} 
		
		return conn;

	}

}
