<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-yw4l {
	vertical-align: top
}

.btn-link {
	border: none;
	outline: none;
	background: none;
	cursor: pointer;
	color: #0000EE;
	padding: 0;
	text-decoration: underline;
	font-family: inherit;
	font-size: inherit;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fórum - Tarefa Coursera Course</title>
</head>
<body>
	<h1>Ranking do Fórum</h1>
	<br>
	<div>
		<table class="tg">
			<tr>
				<th class="tg-031e" align="center">Colocação</th>
				<th class="tg-031e" align="center">Nome do Usuário</th>
				<th class="tg-031e" align="center">Login do Usuário</th>
				<th class="tg-031e" align="center">Pontuação do Usuário</th>
			</tr>
			<c:forEach var="usuario" items="${usuarios}" varStatus="loop">
				<tr>
					<th class="tg-031e">${loop.index +1}º</th>
					<th class="tg-031e" align="left">${usuario.nome}</th>
					<th class="tg-031e" align="left">${usuario.login}</th>
					<th class="tg-031e" align="right">${usuario.pontos}</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
		<a href="listaDeTopicos">Voltar</a>
	</div>
</body>
</html>