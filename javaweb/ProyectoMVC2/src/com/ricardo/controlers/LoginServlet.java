package com.ricardo.controlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricardo.database.BBDD;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailrecibido = request.getParameter("email");
		String passwordrecibido = request.getParameter("password");

		// mensajes que ayudan al programador para ver en la consola que funciona el
		// post:
		System.out.println("Estoy en el post!!");
		System.out.println("Email:" + emailrecibido);
		System.out.println("Password:" + passwordrecibido);

		// Si existe o no el usuario:
		BBDD bd = new BBDD();

		boolean existeUsuario = bd.exiseUsuarioPorEmailYPassword(emailrecibido, passwordrecibido);

		// decidir si existe usuario con ese email y passwor...entrar en lista usuarios,
		// sino volver a mostra formulario:

		HttpSession sesion = request.getSession();

		if (existeUsuario) {

			sesion.setAttribute("usuario", emailrecibido);
			// llevarlo a lista usuario
			// sirven las 2 rutas que vienen a continuacion pero la de forward te deja
			// acceder a la pag siguiente si conoces su URL y redirect no te deja si no
			// est�s previamente registrado:
			// request.getRequestDispatcher("/listausuarios").forward(request, response);
			response.sendRedirect("listausuarios");
		} else {
			// devolverlo a login con un error si los datos no son correctos:
			request.setAttribute("errormensaje", "Usuario y contrase�a no existe!!");
			this.doGet(request, response);
		}

	}
}
