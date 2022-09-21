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

	  <h3>Cadastramento de produtos</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Nome</th>
	        <th>Valor</th>
	        <th>Código</th>
	        <th>Gelada</th>
	        <th>Tamanho</th>
	        <th>Marca</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>Energ</td>
	        <td>R$10,00</td>
	        <td>123</td>
	        <td>Gelada</td>
	        <td>500ml</td>
	        <td>Power</td>
	      </tr>
	      <tr>
	        <td>Coooooofff</td>
	        <td>R$5,00</td>
	        <td>234</td>
	        <td>Quente</td>
	        <td>100ml</td>
	        <td>Cafezin</td>
	      </tr>
	      <tr>
	        <td>Chope</td>
	        <td>R$100,00</td>
	        <td>345</td>
	        <td>Gelada</td>
	        <td>1L</td>
	        <td>Brahma</td>
	      </tr>
	    </tbody>
	  </table>
	</div>	
</body>
</html>