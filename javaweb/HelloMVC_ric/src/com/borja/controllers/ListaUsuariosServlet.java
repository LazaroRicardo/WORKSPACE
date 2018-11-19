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

@WebServlet("/listausuarios")
public class ListaUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//Si existe el dato usuario en session -> lo dejo pasar
		// Si no lo redirijo a login
		if(session.getAttribute("usuario")!=null) {
			BBDD bbdd = BBDD.getInstance();
			request.setAttribute("losUsuarios", bbdd.usuarios);
			request.getRequestDispatcher("/ListaUsuarios.jsp").forward(request, response);	
		}else {
			response.sendRedirect("login");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
