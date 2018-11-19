package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borja.database.BBDD;
import com.borja.models.Usuario;

@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("usuario") != null) {

			String idusuario = request.getParameter("id");
			System.out.println("id recibido:" + idusuario);

			int idU = Integer.parseInt(idusuario);
			BBDD bbdd = BBDD.getInstance();

			request.setAttribute("elusuario", bbdd.getUsuarioById(idU));

			request.getRequestDispatcher("/usuario.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
