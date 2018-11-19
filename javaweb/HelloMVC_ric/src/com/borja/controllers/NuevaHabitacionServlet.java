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

@WebServlet("/nuevahabitacion")
public class NuevaHabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/nuevahabitacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String callerec = request.getParameter("calle");
		String metrosrec = request.getParameter("metros");

		int metrosrecInt = 0;

		try {
			metrosrecInt = Integer.parseInt(metrosrec);
		} catch (Exception e) {
			System.out.println("Excepción!!!!!: " + e.getMessage());
		}
		

		System.out.println("habitacion:" + callerec + ":" + metrosrec);

		Habitacion nuevoHab = new Habitacion(0, callerec, metrosrecInt);

		if (nuevoHab.esValido()) {
			// continuar e introducir el usuario en BBDD
			BBDD db = BBDD.getInstance();
			db.insertaHabitacion(nuevoHab);

			// redirijo a listausuarios
			response.sendRedirect("nuevousuario");

		} else {
			request.setAttribute("mensajeerror", "Datos incorrectos");
			request.setAttribute("nuevahabitacion", nuevoHab);
			this.doGet(request, response);
		}

	}

}
