<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"
	crossorigin="anonymous">
<title>Eliminar producto</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Limpieza</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="Home.jsp">Home</a> 
					<a class="nav-link" href="listarProducto">Listar</a> 
					<a class="nav-link" href="agregarProducto">Agregar Nuevo</a> 
					<a class="nav-link" href="home">logout</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="col-lg-6">
			<h1>Eliminar producto</h1>
			<p>¿Estás seguro de que quieres eliminar el producto?</p>
			<form action="eliminarProducto" method="POST">
				<input type="hidden" name="id_producto" value="${id}" />
				<button class="btn btn-danger" type="submit">Sí</button>
				<a class="btn btn-primary" href="listarProducto">No</a>
			</form>
			<a href="listarProducto">Volver</a>
		</div>
	</div>
</body>
</html>