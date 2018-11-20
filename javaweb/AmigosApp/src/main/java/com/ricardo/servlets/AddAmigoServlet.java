package com.ricardo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.models.Amigo;

/**
 * Servlet implementation class AddAmigoServlet
 */
public class AddAmigoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombrerc=request.getParameter("nombre");
		String emailrc=request.getParameter("email");
		String edadrc=request.getParameter("edad");
		String alturarc=request.getParameter("altura");
		String alopeciarc=request.getParameter("pelo");
		
		System.out.println(nombrerc+":"+
				emailrc+":"+
				edadrc+":"+
				alturarc+":"+
				alopeciarc);
		
		int edadInt = 0;
		double alturaDbl =0;
		boolean alopeciaBool = true;
				
		try {
			edadInt = Integer.parseInt(edadrc);
			alturaDbl = Double.parseDouble(alturarc);
			alopeciaBool = Boolean.parseBoolean(alopeciarc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception:"+e.getMessage());
		}
		
		
		Amigo newAmigo = new Amigo(nombrerc, emailrc, edadInt, alturaDbl, alopeciaBool);
		
		if( newAmigo.esvalid() ) {
			request.setAttribute("unAmigo", newAmigo);
		}else {
			request.setAttribute("messerror", "Datos mal formateados!!!");
		}
		
		doGet(request, response);
	}

}
