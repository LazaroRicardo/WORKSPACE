package com.ricardo.controlers;
//controlador:
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.modelos.Usuario;

//anotación: metodo para modificar un comportamiento de una misma clase, esta dice cual es la ruta de escucha de este servlet:
// no puede haber 2 servlet con la misma ruta.
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Usuario pepe=new Usuario(1, "Jose", "j@j.es",121);
	
		request.setAttribute("elUsuario", pepe);
		//dispacher=despachador, que el jsp devuelva la respuesta. El forward pasa la respuesta a jsp.
		request.getRequestDispatcher("/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
