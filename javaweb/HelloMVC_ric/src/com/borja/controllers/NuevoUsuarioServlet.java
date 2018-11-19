package com.borja.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;
import com.borja.models.Usuario;

@WebServlet("/nuevousuario")
public class NuevoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Habitacion> habitaciones = BBDD.getInstance().habitaciones;

		request.setAttribute("lasHabitaciones", habitaciones);
		request.getRequestDispatcher("/nuevousuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailrec = request.getParameter("email");
		String nombrerec = request.getParameter("nombre");
		String passrec = request.getParameter("pass");
		String confpassrec = request.getParameter("reppass");
		String habitacionrec = request.getParameter("habitacion");
		
		int habitacionrecId = 0;
		
		try {
			habitacionrecId = Integer.parseInt(habitacionrec);
		} catch (Exception e) {
			System.out.println("Excepción!!!!!: " + e.getMessage());
		}
		

		System.out.println("habitacion:" + habitacionrec);

		Usuario nuevoUser = new Usuario(
				0,
				nombrerec,
				emailrec,
				passrec,
				BBDD.getInstance().dameHabitacionPorHid(habitacionrecId)
			);
		
		BBDD db = BBDD.getInstance();

		if (nuevoUser.esValido(confpassrec) && !db.existeEmail(emailrec)) {
			// continuar e introducir el usuario en BBDD
			
			db.insertaUsuario(nuevoUser);

			// redirijo a listausuarios
			response.sendRedirect("listausuarios");

		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("newusuario", nuevoUser);
			this.doGet(request, response);
		}

	}

}
