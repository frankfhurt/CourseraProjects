package br.com.tarefa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.TopicoDAO;
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
		String titulo = request.getParameter("titulo");
		String conteudo = request.getParameter("conteudo");
		Usuario usr = (Usuario) getServletContext().getAttribute("usuarioAutenticado");
		
		if (parametroTipoStringValido(titulo) && parametroTipoStringValido(conteudo ) && usr != null) {
			Topico topico = new Topico();
			
			topico.setTitulo(titulo);
			topico.setConteudo(conteudo);
			topico.setLogin(usr.getLogin());
			
			TopicoDAO topicoDao = new TopicoDAO();
			
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
