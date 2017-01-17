package br.com.coursera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.Livro;
import br.com.coursera.model.Usuario;
import br.com.coursera.service.LivroService;

/**
 * Servlet implementation class ListaDeLivrosServlet
 */
@WebServlet("/listaDeLivros")
public class ListaDeLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivroService service = new LivroService();
	private Usuario usuarioAutenticado;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		validaUsuarioAutenticado(request, response);
		
		List<Livro> livros = service.listarLivros();
		request.setAttribute("livros", livros);
		request.setAttribute("nomeUsuario", usuarioAutenticado.getNome());
		
		request.getRequestDispatcher("listaDeLivros.jsp").forward(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
