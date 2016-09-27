<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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
	vertical-align: top;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fórum - Tarefa Coursera Course</title>
</head>
<body>
	<h1 align="center">Exibição de Tópico</h1>
	<div>
		<h3>
			<u>${topicoUsuario.topico.titulo}</u>
		</h3>
		Autor: ${topicoUsuario.usuario.nome}
	</div>
	<div>
		<table class="tg">
			<tr class="tg-031e" align="left">
				<th>${topicoUsuario.topico.conteudo}</th>
			</tr>
		</table>
		<br>
		<div>
		<h4>Comentários</h4>
			<table class="tg">
				<c:forEach var="comentario" items="${comentarios}">
					<tr align="right">
						<th class="tg-yw4l">${comentario.comentario.comentario}</th>
						<th class="tg-yw4l">${comentario.usuario.nome}</th>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br>
	<div>
		<form action="exibeTopico" method="post">
			<textarea rows="10" cols="50" name="comentario"></textarea>
			<br>
			<input type="submit" value="Enviar Comentário">
		</form>
	</div>
	<a href="listaDeTopicos">Voltar</a>
</body>
</html>