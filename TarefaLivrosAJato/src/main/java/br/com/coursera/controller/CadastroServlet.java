package br.com.coursera.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.Usuario;
import br.com.coursera.service.UsuarioService;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usr = new Usuario();
		
		usr.setNome(new String(request.getParameter("nome").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
		usr.setSenha(new String(request.getParameter("senha").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
		usr.setEmail(new String(request.getParameter("email").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
		
		UsuarioService cadastro = new UsuarioService();
		boolean salvou = cadastro.cadastrarUsuario(usr);
		
		if (salvou)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else {
			request.setAttribute("erroCadastro", "Erro ao efetuar o cadastro. Tente novamente");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
	}

}
