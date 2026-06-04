<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tela De Erro </title>
</head>

<body>
	<h2>Tela de Erro do Sistema</h2>
	<h3 >Por favor entre em contado com o suporte!!!!</h3>
	
	<span style="text:bold;">
		<%out.print(request.getAttribute("msg")); %>
	</span>
</body>
</html>