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

.btn-link{
  border:none;
  outline:none;
  background:none;
  cursor:pointer;
  color:#0000EE;
  padding:0;
  text-decoration:underline;
  font-family:inherit;
  font-size:inherit;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tópicos</title>
</head>
<body>
	<h1>Tópicos</h1>
	<br>
	<div>
		<table class="tg">
			<c:forEach var="topicoUsuario" items="${topicosUsuarios}">
				<tr>
					<th class="tg-031e">
						<a href="exibeTopico?id=${topicoUsuario.topico.id}">${topicoUsuario.topico.titulo}</a>
					</th>
					<th class="tg-yw4l" id="nomeUsuario">${topicoUsuario.usuario.nome}</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<div>
		<a href="insereTopico.jsp">Inserir Tópico</a>
		<a href="ranking.jsp">Ranking</a>
	</div>
</body>
</html>