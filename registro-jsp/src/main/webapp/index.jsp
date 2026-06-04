<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Minha primeira página em jsp</title>
</head>

<body>
	<h1>Olá Bem Vindo ao Login de resgisto em JSP !!</h1>
	
	<br/>
	
	<form action="ServletLogin" method="post">
		<table>
			<tr>
				<td><label>Login:</label> </td>
				<td><input type="text" name="login"/></td>
			</tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input type="password" name="senha"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Enviar"/></td>
			</tr>
		</table>
		
	</form>
	<span>${msg}</span>

</body>

</html>