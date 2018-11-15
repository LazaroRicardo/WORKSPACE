package com.ricardo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.bbdd.BBDDCanciones;

@WebServlet("/listacanciones")
public class CancionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//recolectar canciones de base de datos  
		BBDDCanciones bbdd = new BBDDCanciones();

		//pasar al jsp las canciones		
		request.setAttribute("lasCanciones", bbdd.canciones);
		
		request.getRequestDispatcher("/listacanciones.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
