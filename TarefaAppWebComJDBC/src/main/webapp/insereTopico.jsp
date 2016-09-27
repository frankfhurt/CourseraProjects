<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fórum - Tarefa Coursera Course</title>
</head>
<body>
	<h1 align="center">Novo Tópico</h1>
	<div align="center">
		<form action="inserirTopico" method="post">
			Titulo: <input type="text" name="titulo">
			<br><br>
			Conteúdo:
			<br>
			<textarea rows="10" cols="50" name="conteudo"></textarea>
			<br> 
			<input type="submit" value="Criar Tópico">
		</form>
	</div>
</body>
</html>