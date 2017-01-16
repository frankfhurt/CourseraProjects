package br.com.coursera.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.Livro;
import br.com.coursera.model.Usuario;
import br.com.coursera.service.LivroService;
import br.com.coursera.service.UsuarioService;

/**
 * Servlet implementation class VizualizarLivroServlet
 */
@WebServlet("/visualizarLivro")
public class LivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivroService livroService = new LivroService();
	private UsuarioService usuarioService = new UsuarioService();
	Usuario usuarioAutenticado;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		validaUsuarioAutenticado(request, response);
		
		if (request.getParameter("id") != null)
			request.getSession().setAttribute("id", request.getParameter("id"));
		
		Long id = Long.valueOf((String) request.getSession().getAttribute("id"));
		
		Livro livro = livroService.buscarPorId(id);
		
		boolean jaLido = usuarioService.verificarLeitura(usuarioAutenticado.getEmail(), livro);
		String textButton;
		
		if (jaLido)
			textButton = "Livro já Lido";
		else
			textButton = "Marcar Como Lido";
		
		request.setAttribute("livro", livro);
		request.setAttribute("buttonText", textButton);
		
		request.getRequestDispatcher("visualizarLivro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void validaUsuarioAutenticado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioAutenticado = (Usuario) getServletContext().getAttribute("usuarioAutenticado");
			if (usuarioAutenticado == null)
				throw new Exception();
		} catch (Exception e) {
			request.setAttribute("erroLogin", "Usuario não autenticado!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
