package br.com.coursera.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.Usuario;
import br.com.coursera.service.UsuarioService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService service = new UsuarioService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
		try {
			Usuario usuarioAutenticado = service.efetuarLogin(login, senha);
			getServletContext().setAttribute("usuarioAutenticado", usuarioAutenticado);
			String nomeUsuario = usuarioAutenticado.getNome();
			request.setAttribute("nome", nomeUsuario);
			request.getRequestDispatcher("listaDeLivros").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("erroLogin", "Erro ao autenticar Usuario");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
