package com.ricardo.controlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.database.BBDD;
import com.ricardo.modelos.Habitacion;

@WebServlet("/agnadirhabitacion")
public class AgnadirHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/agnadirhabitacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String callerecibida = request.getParameter("calle");
		String metroscuadradosrecibidos = request.getParameter("metros2");
//para que si meten letras en lugar de metros2 aparezca el mensaje "datos incorrectos":
// esto es para que no me hackeen borrando el html y viendo el mensaje interno de la consola.
		int metroscuadradosrecibidosInt = 0;

		try {
			metroscuadradosrecibidosInt = Integer.parseInt(metroscuadradosrecibidos);
		} catch (Exception e) {
			System.out.println("Excepción!!!: " + e.getMessage());
		}

		System.out.println("Nuevo habitacion recibida:");
		System.out.println("Calle:" + callerecibida);
		System.out.println("Metros Cuadrados:" + metroscuadradosrecibidos);

		Habitacion nuevaHabitacion = new Habitacion(0, callerecibida, metroscuadradosrecibidosInt);

		if (nuevaHabitacion.esValido()) {

			// volver atras si no están correctos los datos:

			BBDD bd = BBDD.getInstance();
			bd.insertaHabitacion(nuevaHabitacion);

			response.sendRedirect("registrarse");

		} else {
			// mensajeerror: está enlazado al jsp cuando no se cumplan los ij, sino los else
			// y se active.
			// datos incorrectos: mensaje que te sale en el jsp si se activa mensajeerror
			request.setAttribute("mensajeerror", "Datos incorrectos");
			// Parametro_para_llamar: palabra que no sirve para nada, pero es necesaria para
			// unir "nuevaHabitacion" al request.
			request.setAttribute("Parametro_para_llamar", nuevaHabitacion);
			this.doGet(request, response);
		}
	}
}
