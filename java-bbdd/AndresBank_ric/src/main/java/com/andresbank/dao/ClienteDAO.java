package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.andresbank.models.Cliente;

public class ClienteDAO {

	private static ClienteDAO instance = null;

	//al poner esto me da error y con el throws le paso la pelota a lo que me pida esta función y lo hago una excepción:
	public static ClienteDAO getInstance() throws Exception {
		if (instance == null)
			instance = new ClienteDAO();

		return instance;
	}

	//manera de instanciar cuando quiero pasar el nombre de la clase a instanciar usando un string:
	private ClienteDAO() throws Exception {
		//para instanciar y unir a la base de datos necesito este driver y meter la dependencia en pom:
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}

	// coger usuario por dni y contraseña:
	public Cliente getUserByDNIAndPass(String dnirec, String passrec) throws SQLException {
		Cliente resCliente = null;
		//enlace url donde se encuentra la bd añadiendo su usuario y contraseña para acceder:
		String url = "jdbc:mysql://localhost/andresbank";
			//con el driver creado lanzo una conexion pasando la url, usuario y passwor de la bd real:
			Connection conn = DriverManager.getConnection(url, "root", "root");
			//estoy pidiendo al usuario de la base de datos:
			String sql= "SELECT uid, nombre, dni, pin, nomina FROM cliente WHERE  pin=? AND dni=?"; 
//Se puede poner así: "SELECT uid, nombre, dni, pin, nomina FROM client WHERE pin='mmmm' AND dni='12345678M'" "SELECT c.* FROM cliente c WHERE pin='mmmm' AND dni='12345678M'"
			
			//Preparar la orden:
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, passrec);
			psmt.setString(2, dnirec);
			
			//ejecuta la orden indicada:
			ResultSet rs = psmt.executeQuery();
			
			System.out.println("Resultset:" +rs);
			
			while(rs.next()) {
				System.out.println("Resulset:"+rs.getInt(1)+"::"+rs.getString(2));
				resCliente = new Cliente (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		
		return resCliente;
	}
}
