<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Minha primeira página em jsp</title>
</head>

<body>
	<h1>Olá JSP Bem Vindo !!!!!</h1>
	
	<%
		out.print("Olá JSP Bem Vindo !!!!");
	%>
	<br/>
	
	<form action="mostra-nome.jsp">
		<input type="text" name="nome"/>
		<input type="text" name="idade"/>
		<input type="submit" value="Enviar"/>
	</form>

</body>

</html>