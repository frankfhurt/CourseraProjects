

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConversaoDeTemperaturaServlet
 */
@WebServlet("/converter")
public class ConversaoDeTemperaturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipoConversao = request.getParameter("tipoDeConversao");
		Integer temperatura = 0;
		String resultado;

		temperatura = Integer.parseInt(request.getParameter("temperatura"));
		
		if ("cToF".equals(tipoConversao))
			resultado = String.valueOf(((temperatura * 9) / 5) + 32);
		else
			resultado = String.valueOf(((temperatura - 32) * 5) / 9);
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado da Conversão</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>O resultado da conversão foi: " + resultado + "</h1>");
			out.println("<a href=\"http://localhost:8080/ConversaoDeTemperaturaWeb/index.html\">Voltar</a>");
			out.println("</body>");
			out.println("</html>");
		}		
		
	}
}
