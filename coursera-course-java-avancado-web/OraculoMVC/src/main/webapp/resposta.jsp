<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Resposta dos Melhores Produtos</title>
</head>
<body>
	<h1>Os melhores produtos do tipo # ${param.produto} # são:</h1>
	<ul>
		<c:forEach var="item" items="${produtos}">
			<li>${item}</li>
		</c:forEach>
	</ul>
</body>
</html>