package br.com.tarefa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.TopicoDAO;
import br.com.tarefa.model.TopicoUsuario;

/**
 * Servlet implementation class ListagemDeTopicosServlet
 */
@WebServlet("/listaDeTopicos")
public class ListagemDeTopicosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TopicoDAO topicoDAO = new TopicoDAO();
		
		List<TopicoUsuario> topicosUsuarios = topicoDAO.getTopicos();
		request.setAttribute("topicosUsuarios", topicosUsuarios);
		
		request.getRequestDispatcher("listaDeTopicos.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
