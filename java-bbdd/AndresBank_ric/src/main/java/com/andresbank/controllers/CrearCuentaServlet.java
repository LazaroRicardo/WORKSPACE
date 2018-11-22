package com.andresbank.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.dao.CuentaDAO;
import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CrearCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// si intenras entrar al url crearcuenta que no te deje y te envie al login si
		// no te metes desde un usuario registrado, esto también se hace en el post para
		// que si pasa mucho tiempo y se deslogea estando dentro del URL no pueda
		// rellenar el formulario:

		if (request.getSession().getAttribute("dni") != null) {
			request.getRequestDispatcher("crearcuenta.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// si intenras entrar al url crearcuenta que no te deje si no te metes desde un
		// usuario registrado:
		if (request.getSession().getAttribute("dni") != null) {
			String nombrerec = request.getParameter("nombre");
			String numerorec = request.getParameter("numero");
			String saldosrec = request.getParameter("saldo");
			
			try {

				double saldosrecDbl = Double.parseDouble(saldosrec);
				
				String dnisess = (String) request.getSession().getAttribute("dni");
				
				Cuenta newCuenta=new Cuenta(0, nombrerec, numerorec, saldosrecDbl);
				Cliente miCliente= ClienteDAO.getInstance().getUserByDNI(dnisess);
				
				//la parte que nombro como "unaCuenta" puede ser tambien un int y un double: 
				Cuenta unaCuenta = CuentaDAO.getInstance().addNewCuenta(newCuenta, miCliente);
				if (unaCuenta != null) {
					// siguiente linea es para que la pagina no te pida el dni todo el rato:
					// request.getSession().setAttribute("dni", nombrerec);

					response.sendRedirect("cuentas");
				} else {
					request.setAttribute("mensaje_error",
							"La cuenta no se ha creado!!! Verifica datos e inténtalo nuevamente.");
					doGet(request, response);
				}

			} catch (Exception e) {
				System.out.println("Excepcion:" + e.getMessage());
				request.setAttribute("mensaje_error",
						"Oppps...tenemos un problemita...búscate otro banco de calidad tacaño!!!");
				doGet(request, response);
			}
			// el else va relacionado con el if que está encima de los string para que te
			// redirija al login si no estas registrado e intentas crear una cuenta nueva:
		} else {
			response.sendRedirect("login");
		}
	}
}
