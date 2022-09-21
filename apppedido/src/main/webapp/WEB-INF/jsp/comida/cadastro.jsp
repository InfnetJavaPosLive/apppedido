<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>	

	<div class="container mt-3">
	  <h2>Cadastramento de Comidas</h2>
	  <form action="/comida/incluir" method="post">
		<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>

	    <div class="mb-3 mt-3">
	      <label>Vegano:</label>
		  <label class="radio-inline">
		      <input type="radio" name="vegano" value="true" checked> Sim
		  </label>
		  <label class="radio-inline">
		      <input type="radio" name="vegano" value="false"> Não
		  </label>
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Peso:</label>
	      <input type="text" class="form-control" placeholder="Entre com o peso do produto" name="peso">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Ingredientes:</label>
	      <input type="text" class="form-control" placeholder="Entre com os ingredientes do produto" name="ingredientes">
	    </div>	    

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
			
</body>
</html>