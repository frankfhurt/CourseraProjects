<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Esse eu já li!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<body>
	<div class="w3-container">

		<h2>Lista de Livros</h2>

		<table class="w3-table-all">
			<thead>
				<tr class="w3-green">
					<th>Título do Livro</th>
					<th>Quantidade de Páginas</th>
				</tr>
			</thead>
			<c:forEach var="livro" items="${livros}">
				<tr class="w3-hover-gray" >
					<td id="titulo">
						<a href="visualizarLivro?id=${livro.id}">${livro.titulo}</a>
					</td>
					<td id="paginas">${livro.qtdPaginas}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
