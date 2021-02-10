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

//	Excécution avec:http://localhost:8080/tp-java-ee/hello-world
@SuppressWarnings({ "unused", "serial" })
@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter writer = resp.getWriter();
		writer.print("<h1>Hello World !</h1>");
		// writer.print("<h1>Bonjour le monde, il est "+new Date() + "</h1>");

	}

}
