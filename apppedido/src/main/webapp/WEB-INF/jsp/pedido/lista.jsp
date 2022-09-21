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

	  <h3>Cadastramento de pedidos</h3>	              

	  <h4><a href="/pedido">Novo</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	      	<th>ID</th>
	        <th>Descrição</th>
	        <th>Data</th>
	        <th>Web</th>
	        <th>Solicitante</th>
	        <th>Produtos</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="p" items="${listagem}">	
		      <tr>
		        <td>${p.id}</td>
		        <td>${p.descricao}</td>
		        <td>${p.data}</td>
		        <td>${p.web}</td>
		        <td>${p.solicitante.nome}</td>
		        <td>${p.produtos.size()}</td>
		        <td><a href="/pedido/${p.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	</div>	
</body>
</html>