package br.com.tarefa.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.TopicoDAO;
import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.dao.UsuarioDAOImpl;
import br.com.tarefa.model.Topico;
import br.com.tarefa.model.Usuario;

/**
 * Servlet implementation class InserirTopicoServlet
 */
@WebServlet("/inserirTopico")
public class InserirTopicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = new String(request.getParameter("titulo").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		String conteudo = new String(request.getParameter("conteudo").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		Usuario usr = (Usuario) getServletContext().getAttribute("usuarioAutenticado");
		
		if (parametroTipoStringValido(titulo) && parametroTipoStringValido(conteudo ) && usr != null) {
			Topico topico = new Topico();
			TopicoDAO topicoDao = new TopicoDAO();
			UsuarioDAO usrDAO = new UsuarioDAOImpl();
			
			topico.setTitulo(titulo);
			topico.setConteudo(conteudo);
			topico.setLogin(usr.getLogin());
			
			usrDAO.adicionarPontos(usr.getLogin(), 10);
			topicoDao.inserir(topico);
			
			request.getRequestDispatcher("listaDeTopicos").forward(request, response);
		} else {
			request.getRequestDispatcher("insereTopico.jsp").forward(request, response);
		}
	}

	private boolean parametroTipoStringValido(String parametro) {
		return parametro != null && !parametro.isEmpty();
	}
}
