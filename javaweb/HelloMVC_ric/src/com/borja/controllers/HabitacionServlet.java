package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borja.database.BBDD;
import com.borja.models.Habitacion;

@WebServlet("/habitacion")
public class HabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("usuario") != null) {

			String idhabitacion = request.getParameter("hid");
			System.out.println("hid recibido:" + idhabitacion);

			int idH = Integer.parseInt(idhabitacion);

			BBDD bbdd = BBDD.getInstance();

			request.setAttribute("laHabitacion", bbdd.dameHabitacionPorHid(idH));

			request.getRequestDispatcher("/Habitacion.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
