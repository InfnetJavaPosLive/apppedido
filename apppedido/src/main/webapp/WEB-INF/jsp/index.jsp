<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
</head>
<body>
	<div class="container mt-3">
	  <h2>AppPedido</h2>
	  <p>Projeto de Gestão de Pedidos</p>
	  
	  <h3>Classe: Pedido</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descrição</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>descricao</td>
	        <td>String</td>
	        <td>Descrição do pedido</td>
	      </tr>
	      <tr>
	        <td>data</td>
	        <td>LocalDateTime</td>
	        <td>Data de realização do pedido</td>
	      </tr>
	      <tr>
	        <td>web</td>
	        <td>boolean</td>
	        <td>Indicativo para um pedido online ou presencial</td>
	      </tr>
	    </tbody>
	  </table>

	  <h3>Classe: Bebida</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descrição</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>gelada</td>
	        <td>boolean</td>
	        <td>Indicativo se a bebida é gelada ou não</td>
	      </tr>
	      <tr>
	        <td>tamanho</td>
	        <td>float</td>
	        <td>Quantidade de líquido da bebida</td>
	      </tr>
	      <tr>
	        <td>marca</td>
	        <td>String</td>
	        <td>Marca da bebida</td>
	      </tr>
	    </tbody>
	  </table>
	</div>	
</body>
</html>