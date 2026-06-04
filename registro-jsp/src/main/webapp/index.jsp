<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Minha primeira página em jsp</title>
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style type="text/css">
		.container{
			margin-left: 30%;
			margin-top: 5%;
		}
	</style>
</head>

<body>
	<h1 style="text-align:center;">Olá Bem Vindo ao Login de resgisto em JSP !!</h1>
	
	<br/>
	
	<div class="container">	
  		<div class="row ">
			<form action="ServletLogin" method="post">
				<input type="hidden" value= "<%=request.getParameter("url") %>" name="url">
				<div class="col-4">
					<div class="mb-3">
			  			<label  class="form-label">Login:</label>
			  			<input type="text" class="form-control" id="login" name="login">
					</div>
				</div>
				
				<div class="col-4">
					<div class="mb-3">
			  			<label  class="form-label">Senha:</label>
			  			<input type="password" class="form-control" id="senha" name="senha">
					</div>
				</div>
				<div class="col-12">
					<input class="btn btn-primary" type="submit" value="Enviar"/>
				</div>
			</form>
		</div>
	</div>
	<span>${msg}</span>
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	

</body>

</html>