package br.com.tarefa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.model.TopicoUsuario;
import br.com.tarefa.repositorio.Autenticador;
import br.com.tarefa.repositorio.TopicoDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
	
		Autenticador aut = new Autenticador();
		TopicoDAO topicoDAO = new TopicoDAO();
		
		try {
			String nomeUsuario = aut.autenticar(login, senha);
			request.setAttribute("nome", nomeUsuario);
			
			List<TopicoUsuario> topicosUsuarios = topicoDAO.getTopicos();
			request.setAttribute("topicosUsuarios", topicosUsuarios);
			
			request.getRequestDispatcher("topicos.jsp").forward(request, response);
		} catch (Exception e) {
			String erro = e.getMessage() + "<br>" + "<a href=\"http://localhost:8080/TarefaAppWebComJDBC/cadastro.jsp\">Criar Cadastro</a>";
			request.setAttribute("erroLogin", erro);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
