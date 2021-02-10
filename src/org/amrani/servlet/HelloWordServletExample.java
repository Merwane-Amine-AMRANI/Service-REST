package org.amrani.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amrani.model.Commune;

@SuppressWarnings({ "unused", "serial" })
@WebServlet(urlPatterns = "/commune")
public class HelloWordServletExample extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// PrintWriter writer = resp.getWriter();
		// writer.print("<h1>Bonjour le monde, il est "+new Date() + "</h1>");

		String codePostal = req.getParameter("cp");
		Commune commune = new Commune(codePostal, "Paris");

		// Commune commune = new Commune("75000","Paris");
		req.setAttribute("commune", commune);
		RequestDispatcher rd = req.getRequestDispatcher("commune.jsp");
		rd.forward(req, resp);
	}

}
