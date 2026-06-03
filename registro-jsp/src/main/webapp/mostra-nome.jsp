<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de mostra nome</title>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		out.print(nome+"\n");
		
		String idade = request.getParameter("idade");
		out.print("\n"+idade);
	%>
</body>
</html>