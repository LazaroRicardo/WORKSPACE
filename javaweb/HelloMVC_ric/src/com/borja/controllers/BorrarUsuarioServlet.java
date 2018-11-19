package com.borja.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//he puesto un enlace en listausuarios.jsp que está relacionado con este servlet al poner el mismo nombre en el @, 
//después quiero que este servlet le pase la pelota al servlet de listausuario para poder borrar datos de esa lista 
//y se hace metiendo un sendredirect en el doGet:

import com.borja.database.BBDD;

@WebServlet("/borrarusuario")
public class BorrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//recoger id de usuario a borrar:
		String idrec = request.getParameter("id");
		

		//borrar usuario de bbdd
		int idInt = Integer.parseInt(idrec);
		
		BBDD.getInstance().borrarUsuarioPorId(idInt);
		
		//volver a redirigir a listausuarios
		response.sendRedirect("listausuarios");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
