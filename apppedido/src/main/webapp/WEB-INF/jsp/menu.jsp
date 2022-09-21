<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">Home</a>
	      </li>

	      <c:if test="${not empty user}">
		      <li class="nav-item">
		        <a class="nav-link" href="/usuario/lista">Usuário</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/bebida/lista">Bebida</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/comida/lista">Comida</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/sobremesa/lista">Sobremesa</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/produto/lista">Produto</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/solicitante/lista">Solicitante</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/pedido/lista">Pedido</a>
		      </li>
	      </c:if>
	    </ul>
	    
	    <ul class="navbar-nav">
       	  <c:if test="${empty user}">
		      <li class="nav-item">
		        <a class="nav-link" href="/usuario">Signup</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="/login">Login</a>
		      </li>
	      </c:if>
	      
	      <c:if test="${not empty user}">
		      <li class="nav-item">
		        <a class="nav-link" href="/logout">Logout, ${user.nome}</a>
		      </li>
	      </c:if>
	    </ul>
	  </div>
	</nav>