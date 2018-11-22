package com.andresbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;
import com.mysql.jdbc.Statement;

public class CuentaDAO {

	private static CuentaDAO instance = null;

	// al poner esto me da error y con el throws le paso la pelota a lo que me pida
	// esta función y lo hago una excepción:
	public static CuentaDAO getInstance() throws Exception {
		if (instance == null)
			instance = new CuentaDAO();

		return instance;
	}

	// manera de instanciar cuando quiero pasar el nombre de la clase a instanciar
	// usando un string:
	private CuentaDAO() throws Exception {
		// para instanciar y unir a la base de datos necesito este driver y meter la
		// dependencia en pom:
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}

	// QUIERO QUE SE VEAN TODAS LAS CUENTAS POR LO QUE HE CRERAD UN ARRAY:
	public ArrayList<Cuenta> getCuentasByDni(String dnirec) throws SQLException {
		// AQUI INDICO QUE EL ARRAY SE LLAMA "RESCUENTAS" Y QUE ES NULO PARA QUE ME DEJE
		// SEGUIR EDITANDO:
		ArrayList<Cuenta> resCuentas = null;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");
		// PARA QUE SE MUESTRE TODO LO QUE CONTIENEN LAS CUENTAS EN BBDD:
		String sql = "SELECT c.cid, c.nombre, c.numero, c.saldo FROM cuenta c, cliente_cuenta cc, cliente cl  WHERE c.cid=cc.cuenta AND cl.uid=cc.cliente AND cl.dni=?";

		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, dnirec);

		ResultSet rs = psmt.executeQuery();

		System.out.println("Resultset:" + rs);
		// HAGO QUE RESCUENTAS SEA UN ARRAY Y DEJE DE SER NULO PARA AÑADIRLE EN EL WHILE
		// UNA CUENTA:
		// CREO EL ARRAYLIST AQUI ABAJO PARA QUE LA CONEXION NO ME DE PROBLEMAS DE
		// EXCEPCION:
		// YA QUE ARRIBA O AQUI ABAJO PODIA HACER ESTO => ArrayList<Cuenta> resCuentas =
		// new ArrayList<Cuenta>();
		resCuentas = new ArrayList<Cuenta>();
		// while muestra lo que le pides igual que un for, pero sin necesidad de
		// marcarle que vaya de principio a fin:
		// empieza por la primera cuenta en el orden indicado y acaba en la ultima que
		// exista:
		while (rs.next()) {
			System.out.println("Resulset:" + rs.getInt(1) + "::" + rs.getString(2));
			resCuentas.add(new Cuenta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		}

		System.out.println("Arraylist resultante:" + resCuentas);

		rs.close();
		psmt.close();
		conn.close();

		return resCuentas;
	}

	// parte que pertenece a crear cuenta:
	public Cuenta addNewCuenta(Cuenta cuenta, Cliente cliente) throws Exception {
		// puedes ponerlo de tipo objeto (cuenta), int o double:
		Cuenta cuentaRespuesta = null;

		String url = "jdbc:mysql://localhost/andresbank";

		Connection conn = DriverManager.getConnection(url, "root", "root");

		String sql = "INSERT INTO cuenta (nombre, numero, saldo) VALUES (?, ?, ?)";
		// Statement.RETURN_GENERATED_KEYS=> devuelveme la clave generada en el
		// identificador, es decir, como el cid se genera automaticamente en la base de
		// datos yo le pido que me lo devuelva:
		PreparedStatement psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// lo próximo lo sacamos de getters y setters del modelo:
		psmt.setString(1, cuenta.getNombre());
		psmt.setString(2, cuenta.getNumero());
		psmt.setDouble(3, cuenta.getSaldo());

		// para ejecutarlo, para conseguir que se haga el insert:
		psmt.executeUpdate();

		// Proximas lineas para que al crear cuenta te envie el cid de la cuenta y
		// puedas pasar al URL de cuentas con la cuenta creada.
		ResultSet rs = psmt.getGeneratedKeys();

		if (rs.next()) {
			cuentaRespuesta = cuenta;
			cuenta.setCid(rs.getInt(1));
		}
		// se cierran las conexiones para que no ocupen parte de los recursos mientras
		// no se usan:
		rs.close();
		psmt.close();

		// insertar cliente-cuenta:
		// esta parte asocia la cuenta creada con la parte anterior y la asocia al
		// cliente que tu hayas seleccionado en el login:
		sql = "INSERT INTO cliente_cuenta (cliente, cuenta) VALUES (?, ?);";
		psmt = conn.prepareStatement(sql);
		psmt.setInt(1, cliente.getUid());
		psmt.setInt(2, cuentaRespuesta.getCid());

		psmt.executeUpdate();

		psmt.close();
		conn.close();

		return cuentaRespuesta;
	}

}
