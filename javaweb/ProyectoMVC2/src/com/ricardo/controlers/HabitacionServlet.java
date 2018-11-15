package com.ricardo.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.BBDD;

@WebServlet("/habitacion")
public class HabitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//nuevo contenido:
		//String idUsuario = request.getParameter("id");
		//System.out.println("ID recibido:" + idUsuario);
		//int idU=Integer.parseInt(idUsuario);
		String idHabitacion = request.getParameter("hid");
		System.out.println("HID recibido:" + idHabitacion);
		int hidH=Integer.parseInt(idHabitacion);
		
		HttpSession session = request.getSession();

		// Si exsiste el dato usuario en sesion lo dejo pasar, sino lo redirijo a login,
		// sirve para que un usuario no se meta a una pagina siguiente sin haber a�adido
		// contrase�a si es que se conoce el URL de la pag siguiente y que al hacerlo le
		// redirija al login.
		if (session.getAttribute("usuario") != null) {
			BBDD bbdd = new BBDD();
			// En el request asocio: el atributo "losusuarios" se enlaza a la base de
			// datos[bbdd] y en la clase jsp si lo pongo con "${}" me saldr� lo que se
			// encuantra en bbdd
			request.setAttribute("laHabitacion", bbdd.getHabitacionById(hidH));

			request.getRequestDispatcher("/habitacion.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
