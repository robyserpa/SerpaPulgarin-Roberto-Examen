<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Telefono</title>
</head>
<body>
	<header>
		<H1>Telefono</H1>
		<nav>
			<div>
				<a href="/SerpaPulgarin-Roberto-Examen/JSP/login.jsp"></a>
			</div>
		</nav>
	</header>
	<DIV>
		<c:set var="tipos" scope="request" value="${tipos}" />
		<c:set var="operadoras" scope="request" value="${operadoras}" />
		
		<H2>Agregar Telefono</H2>
		
		<p>Numero: <input type="text" name="usu_name"></p>
		
		<BR />
		<p>tipo:<P />
		
		<table>
		<tr>
			<td><strong>tipo</strong></td>
		</tr>
		<c:forEach var="t" items="${tipos}">
			<tr>
				<td>${t.tipNombre}</td>
			</tr>
		</c:forEach>
		
		
		<BR />
		<c:forEach var="t" items="${tipos}">
			<input type="radio" name="tip_nombre" value="${t.tipNombre}">${t.tipNombre}<br>
		</c:forEach>
		<BR />
		<p>Operadora:<P />
		<BR />
		<c:forEach var="o" items="${operadoras}">
			<input type="radio" name="tip_nombre" value="${o.opeNombre}">${o.opeNombre}<br>
		</c:forEach>


		<INPUT type="submit" value="crear"/>
	</DIV>
</body>
</html>