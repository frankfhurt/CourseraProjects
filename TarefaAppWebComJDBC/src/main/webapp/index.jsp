<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fórum - Tarefa Coursera Course</title>
</head>
<body>
	<h1 align="center">Acesso</h1>
	<div align="center">
		<form method="post" action="login">
			Login: <input type="text" name="login" /> <br> 
			Senha: <input type="password" name="senha" /> <br>
			<input type="submit" value="Login" />
		</form>
	</div>
	<div align="center">
		${erroLogin} <br>
		<a href="cadastro">Criar Cadastro</a>
	</div>
</body>
</html>