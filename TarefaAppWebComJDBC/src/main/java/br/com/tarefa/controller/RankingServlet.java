package br.com.tarefa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.dao.UsuarioDAOImpl;
import br.com.tarefa.model.Usuario;

/**
 * Servlet implementation class RankingServlet
 */
@WebServlet("/ranking")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usrDao = new UsuarioDAOImpl();
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios = usrDao.ranking();
		
		request.setAttribute("usuarios", usuarios);
		
		request.getRequestDispatcher("ranking.jsp").forward(request, response);
	}
}
