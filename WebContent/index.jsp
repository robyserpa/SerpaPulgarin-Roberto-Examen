<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	<header>
		<script src="/SerpaPulgarin-Roberto-Examen/JS/funciones.js"></script>
		<H1>Inicio</H1>
		<nav>
			<div>
				<a href="/SerpaPulgarin-Roberto-Examen/JSP/login.jsp"></a>
			</div>
		</nav>
	</header>
	<DIV>
		<from>
		<H2>Crear usuario</H2>
		
		<p>Nombre: <input type="text" name="usu_nombre" id="usu_nombre"></p>

		<p>Correo: <input type="text" name="usu_correo" id="usu_correo" size="40"></p>

		<p>Cedula: <input type="text" name="usu_cedula" id="usu_cedula" size="20"></p>
		
		<INPUT type="button" value="crear" onclick="crear()"/>
		</from>
	</DIV>
</body>
</html>