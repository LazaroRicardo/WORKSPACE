package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.borja.database.BBDD;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailrecib = request.getParameter("email");
		String passrecib = request.getParameter("password");
		
		BBDD bd = BBDD.getInstance();		
		//decidir si existe usuario con ese email y password...entrar en listausuarios
		//Si no...volver a mostrar formulario
		
		boolean existeUser = bd.existeUsuarioPorEmailYPass(emailrecib, passrecib);
		
		HttpSession session = request.getSession();
		
		if( existeUser ) {
			//llevarlo a lista usuarios
			//request.getRequestDispatcher("/listausuarios").forward(request, response);
			session.setAttribute("usuario", emailrecib);
			response.sendRedirect("listausuarios");
		}else {
			//devolverlo a login
			request.setAttribute("errormensaje", "Usuario y contraseña no existe!!");
			this.doGet(request, response);
		}

	}

}






