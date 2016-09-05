

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oraculoController")
public class OraculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoProduto = request.getParameter("produto");

		Oraculo oraculo = new Oraculo();
		
		List<String> produtos = oraculo.getMelhoresProdutos(tipoProduto);
		
		// coloco no escopo para que a view consiga pegar a lista.
		request.setAttribute("produtos", produtos);
		
		request.getRequestDispatcher("resposta.jsp").forward(request, response);
		// passar o controle para um view
		
	}

}
