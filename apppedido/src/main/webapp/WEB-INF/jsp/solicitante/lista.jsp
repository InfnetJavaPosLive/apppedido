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

		<c:if test="${not empty mensagem}">
			<div class="alert ${tipo}">
			  <strong>Informação</strong> ${mensagem}
			</div>
		</c:if>

	  <h3>Cadastramento de solicitantes</h3>
	  
	  <h4><a href="/solicitante">Novo</a></h4>
	  	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>CPF</th>
	        <th>E-mail</th>
	        <th>Usuário</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
		<c:forEach var="s" items="${listagem}">	    
	      <tr>
	        <td>${s.id}</td>
	        <td>${s.nome}</td>
	        <td>${s.cpf}</td>
	        <td>${s.email}</td>
	        <td>${s.usuario.email}</td>
	        <td><a href="/solicitante/${s.id}/excluir">Excluir</a></td>
	      </tr>
	    </c:forEach>
	    </tbody>
	  </table>
	</div>	
</body>
</html>