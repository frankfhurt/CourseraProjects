package br.com.coursera.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.coursera.model.PalavraNaoEncontradaException;
import br.com.coursera.model.TradutorDePalavras;

/**
 * Servlet implementation class tradutorController
 */
@WebServlet("/tradutor")
public class tradutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final transient ClassLoader classLoader = getClass().getClassLoader();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavra = request.getParameter("palavra");
		String traducao;
		File file = new File(classLoader.getResource("palavras").getFile());
		TradutorDePalavras tradutor = new TradutorDePalavras(URLDecoder.decode(file.getAbsolutePath(), "UTF-8"));
		
		try {
			traducao = tradutor.traduzirPalavra(palavra);
			request.setAttribute("traducao", traducao);
			request.getRequestDispatcher("traducao.jsp").forward(request, response);
		} catch (PalavraNaoEncontradaException e) {
//			request.setAttribute("traducao", palavra);
//			request.getRequestDispatcher("traducao.jsp").forward(request, response);
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("falhaNaTraducao.jsp").forward(request, response);
		}
	}
}
