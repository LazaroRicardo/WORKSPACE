package com.ricardo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ricardo.modelo.AmigoApp;


@WebServlet("/addamigo")

public class AmigoAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/addamigo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idrecibido = request.getParameter("id");
		String namerecibido = request.getParameter("name");
		String edadrecibida = request.getParameter("edad");
		String emailrecibido = request.getParameter("email");
		String alopeciarecibido = request.getParameter("pelo");

		
		int id1 =0;
		int edad2 =0;
		boolean calvo =true;
		
		try {
			id1 =Integer.parseInt(idrecibido);
			edad2 =Integer.parseInt(edadrecibida);
			calvo =Boolean.parseBoolean(alopeciarecibido);
		} catch (Exception e) {
			System.out.println("Exception:" +e.getMessage());
		}
		
		System.out.println("Nuevo amigo recibido");
		System.out.println("id:" + idrecibido);
		System.out.println("Name:" + namerecibido);
		System.out.println("Edad:" + edadrecibida);
		System.out.println("Email:" + emailrecibido);
		System.out.println("Alopecia:" + alopeciarecibido);
		
		AmigoApp nuevoAmigo = new AmigoApp(id1, namerecibido, edad2, emailrecibido, calvo);
		
		request.setAttribute("unAmigo", nuevoAmigo);
		
		//request.setAttribute("id", idrecibido);
		//request.setAttribute("name", namerecibido);
		//request.setAttribute("edad", edadrecibida);
		//request.setAttribute("email", emailrecibido);
		//request.setAttribute("pelo", alopeciarecibido);

		doGet(request, response);
	}

}
