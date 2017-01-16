package br.com.coursera.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.service.LivroService;

/**
 * Servlet implementation class VizualizarLivroServlet
 */
@WebServlet("/visualizarLivro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null)
			request.getSession().setAttribute("id", request.getParameter("id"));
		
		Long id = Long.valueOf((String) request.getSession().getAttribute("id"));
		
		LivroService service = new LivroService();
		
		service.buscarPorId(id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
