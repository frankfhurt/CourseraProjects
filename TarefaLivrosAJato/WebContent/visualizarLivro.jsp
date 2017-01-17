<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Coursera - Esse eu já li!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 5px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

.button2:hover {
    background-color: #008CBA;
    color: white;
}

.disabled {
    opacity: 0.6;
    cursor: not-allowed;
}

body {
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

table {
    border-collapse: collapse;
    width: 50%;
}

th, td {
    text-align: left;
    padding: 8px;
    border-bottom: 1px solid #ddd;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}

</style>
<body>
	<div class="w3-container">
		<form method="get" action="listaDeLivros">
			<button class="button button2">Voltar</button>
		</form>
		<h2>Detalhes do Livro</h2>
		<table>
			<thead>
				<tr>
					<th>Título do Livro</th>
					<th>Quantidade de Páginas</th>
				</tr>
			</thead>
			<tr>
				<td id="titulo">${livro.titulo}</td>
				<td id="paginas">${livro.qtdPaginas}</td>
			</tr>
		</table>
	</div>
	<div class="w3-container">
		<form method="post" action="visualizarLivro">
			<button class="button button1 ${btnStatus}">${buttonText}</button>
		</form>
	</div>
</body>
</html>
