package br.com.coursera.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.Usuario;
import br.com.coursera.service.UsuarioService;

@WebServlet("/trofeusDoUsuario")
public class TrofeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioService usuarioService = new UsuarioService();
	private Usuario usuarioAutenticado;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		validaUsuarioAutenticado(request, response);
		
		String email = request.getParameter("email");
		
		Usuario usuario = usuarioService.buscarPorEmail(email);
		
		if (usuario != null) {
			request.setAttribute("usuario", usuario);
			request.setAttribute("trofeus", usuario.getTrofeus());
			request.getRequestDispatcher("trofeusDoUsuario.jsp").forward(request, response);
		} else {
			request.setAttribute("erroDetalharUsuario", "Erro ao Detalhar Usuario");
			request.getRequestDispatcher("ranking").forward(request, response);
		}
	}

	private void validaUsuarioAutenticado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			usuarioAutenticado = (Usuario) getServletContext().getAttribute("usuarioAutenticado");
			if (usuarioAutenticado == null)
				throw new Exception();
		} catch (Exception e) {
			request.setAttribute("erroLogin", "Usuario não autenticado!/nEfetue o login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
