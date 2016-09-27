package br.com.tarefa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.Autenticador;
import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.dao.UsuarioDAOImpl;
import br.com.tarefa.model.Usuario;

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
		
		UsuarioDAO usrDAO = new UsuarioDAOImpl();
		Usuario usuarioAutenticado = usrDAO.recuperar(login);
		
		if (getServletContext().getAttribute("usuarioAutenticado") == null)
			getServletContext().setAttribute("usuarioAutenticado", usuarioAutenticado);
	
		Autenticador aut = new Autenticador();

		try {
			String nomeUsuario = aut.autenticar(login, senha);
			request.setAttribute("nome", nomeUsuario);
			request.getRequestDispatcher("listaDeTopicos").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erroLogin", e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
