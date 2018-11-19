package com.ricardo.controlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.database.BBDD;
import com.ricardo.modelos.Habitacion;
import com.ricardo.modelos.Usuario;

@WebServlet("/registrarse")
public class RegistrarseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Habitacion> habitaciones = BBDD.getInstance().habitaciones;

		request.setAttribute("lasHabitaciones", habitaciones);

		request.getRequestDispatcher("/registrarse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String namerecibido = request.getParameter("name");
		String emailrecibido = request.getParameter("email");
		String passwordrecibido = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String habitacionrecibida = request.getParameter("habitacionrecibida");

		// para que si meten letras en lugar de metros2 aparezca el mensaje "datos
		// incorrectos":
		// esto es para que no me hackeen borrando el html y viendo el mensaje interno
		// de la consola.
		int obtenerHabitacionId = 0;

		try {
			obtenerHabitacionId = Integer.parseInt(habitacionrecibida);
		} catch (Exception e) {
			System.out.println("Excepción!!!: " + e.getMessage());
		}

		// parsear habitaciones a un int para poder utilizar su ida y que te aparezca la
		// habitación en los nuevos usuarios:
		// int obtenerHabitacionId = Integer.parseInt(habitacionrecibida);

		System.out.println("Nuevo usuario recibido");
		System.out.println("Name:" + namerecibido);
		System.out.println("Email:" + emailrecibido);
		System.out.println("Password:" + passwordrecibido);
		System.out.println("Passwordc:" + confirmpassword);
		System.out.println("habitacionrecibida:" + habitacionrecibida);
		// al final para que aparezcan las habitaciones se lo he pedido a bbdd:
		Usuario nuevoUsuario = new Usuario(0, namerecibido, emailrecibido, passwordrecibido,
				BBDD.getInstance().getHabitacionByHid(obtenerHabitacionId));

		// Continuar e introducir el usuario en bbdd si emailrecibido es diferente de
		// null y no está vacío y que email contenga @:
		// -> if (emailrecibido != null && !emailrecibido.equals("") &&
		// emailrecibido.indexOf("@") > 0) {
		// Nueva manera:
		
		BBDD bd = BBDD.getInstance();
		//que no se repita el mismo email al crear una cuenta:
		if(nuevoUsuario.esValido(confirmpassword) && !bd.existeEmail(emailrecibido)){
		
		//if (nuevoUsuario.esValido(confirmpassword)) {
			// volver atras si no están correctos los datos:

			bd.insertaUsuario(nuevoUsuario);

			response.sendRedirect("listausuarios");

		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("nuevousuario", nuevoUsuario);
			this.doGet(request, response);
		}

	}
}
