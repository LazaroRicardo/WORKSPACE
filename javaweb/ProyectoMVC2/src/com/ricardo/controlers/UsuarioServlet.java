package com.ricardo.controlers;

//controlador:
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.BBDD;

//anotaci�n: metodo para modificar un comportamiento de una misma clase, esta dice cual es la ruta de escucha de este servlet:
// no puede haber 2 servlet con la misma ruta.
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idUsuario = request.getParameter("id");
		System.out.println("ID recibido:" + idUsuario);
		
		int idU=Integer.parseInt(idUsuario);
		
		HttpSession session = request.getSession();

		// Si exsiste el dato usuario en sesion lo dejo pasar, sino lo redirijo a login,
		// sirve para que un usuario no se meta a una pagina siguiente sin haber a�adido
		// contrase�a si es que se conoce el URL de la pag siguiente y que al hacerlo le
		// redirija al login.
		if (session.getAttribute("usuario") != null) {
			BBDD bbdd = BBDD.getInstance();
			// En el request asocio: el atributo "losusuarios" se enlaza a la base de
			// datos[bbdd] y en la clase jsp si lo pongo con "${}" me saldr� lo que se
			// encuantra en bbdd
			request.setAttribute("elUsuario", bbdd.getUsuarioById(idU));
			// dispacher=despachador, que el jsp devuelva la respuesta. El forward pasa la
			// respuesta a jsp.
			request.getRequestDispatcher("/usuario.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
		// capturar parametro (siempre viene en modo string aunque sea un int inicialmente) creo una variable donde
		// recupero un par�metro y uso el syso para elcupirlo por la consola.
		
		//para transformar el idUsuario en un int en lugar de un string y poder a�adirlo al get de mas abajo:
		
		// el new bbdd llama al "public BBDD()" de la clase "BBDD.java" pudiendo usar
		// sus par�metros p�blicos los que a su vez est�n relacionados con los privados.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
