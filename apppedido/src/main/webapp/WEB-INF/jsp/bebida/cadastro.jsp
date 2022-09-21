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
	  <h2>Cadastramento de Bebidas</h2>
	  <form action="/bebida/incluir" method="post">
		<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>

	    <div class="mb-3 mt-3">
	      <label>Gelada:</label>
		  <label class="radio-inline">
		      <input type="radio" name="gelada" value="true" checked> Sim
		  </label>
		  <label class="radio-inline">
		      <input type="radio" name="gelada" value="false"> Não
		  </label>
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Tamanho:</label>
	      <input type="text" class="form-control" placeholder="Entre com o tamanho do produto" name="tamanho">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Marca:</label>
	      <input type="text" class="form-control" placeholder="Entre com a marca do produto" name="marca">
	    </div>	    

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
			
</body>
</html>