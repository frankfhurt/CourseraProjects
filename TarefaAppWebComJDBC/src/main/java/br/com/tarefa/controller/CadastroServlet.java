package br.com.tarefa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.model.Usuario;
import br.com.tarefa.repositorio.CadastraUsuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usr = new Usuario();
		
		usr.setNome(request.getParameter("nome"));
		usr.setLogin(request.getParameter("login"));
		usr.setEmail(request.getParameter("email"));
		usr.setSenha(request.getParameter("senha"));
		
		CadastraUsuario cadastro = new CadastraUsuario(usr);
		boolean salvou = cadastro.cadatrarUsuario();
		
		if (salvou)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else {
			request.setAttribute("erroCadastro", "Erro ao efetuar o cadastro. Tente novamente");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
			
	}
}
