package br.com.tarefa.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tarefa.dao.ComentarioDAO;
import br.com.tarefa.dao.TopicoDAO;
import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.dao.UsuarioDAOImpl;
import br.com.tarefa.model.Comentario;
import br.com.tarefa.model.ComentarioUsuario;
import br.com.tarefa.model.TopicoUsuario;
import br.com.tarefa.model.Usuario;

/**
 * Servlet implementation class TopicoServlet
 */
@WebServlet("/exibeTopico")
public class TopicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("id") != null)
			request.getSession().setAttribute("id", request.getParameter("id"));
		
		Long idTopico = Long.valueOf((String) request.getSession().getAttribute("id"));

		TopicoDAO tpDao = new TopicoDAO();
		ComentarioDAO comentarioDao = new ComentarioDAO();
		
		TopicoUsuario topicoUsuario = tpDao.getTopicoUsuario(idTopico);
		List<ComentarioUsuario> comentarioUsuario = comentarioDao.getComentariosComNomeUsuario(idTopico);
		
		request.setAttribute("topicoUsuario", topicoUsuario);
		request.setAttribute("comentarios", comentarioUsuario);
		
		request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long idTopico = Long.valueOf((String) req.getSession().getAttribute("id"));
		String comentario = new String(req.getParameter("comentario").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		
		if (comentario != null && !comentario.isEmpty()) {
			ComentarioDAO comentarioDao = new ComentarioDAO();
			Comentario coment = new Comentario();
			Usuario usr = (Usuario) getServletContext().getAttribute("usuarioAutenticado");
			UsuarioDAO usuarioDao = new UsuarioDAOImpl();
			
			coment.setComentario(comentario);
			coment.setLogin(usr.getLogin());
			coment.setIdTopico(idTopico);
			
			comentarioDao.inserir(coment);
			usuarioDao.adicionarPontos(usr.getLogin(), 3);
			comentario = null;
		}
		doGet(req, resp);
	}
}