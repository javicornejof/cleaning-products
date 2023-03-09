<%@page import="com.desafiolatam.model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="com.desafiolatam.dao.ProductoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
       <title>Productos de limpieza</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="#">Productos de Limpieza</a>
                    <a class="nav-link" href="listarProducto">Listar</a>
                    <a class="nav-link" href="addControler">Buscar</a>
                    <a class="nav-link" href="addControler">Agregar Nuevo</a>
                    <a class="nav-link" href="addControler">Actualizar</a>
                    <a class="nav-link" href="addControler">Borrar</a>
                    <a class="nav-link" href="addControler">Listar categoría</a>
                    <a class="nav-link" href="addControler">Buscar categoría</a>
                   
                </div>
            </div>
        </div>
    </nav>
    
    <div class="container">
      <form action="agregarProducto" method = "POST">
        <div class="mb-3">
          <label for="nombreProducto" class="form-label" name="nombre">Nombre Producto</label>
          <input class="form-control" id="nombreProducto" name="nombre" type="text">
        </div>
        <div class="mb-3">
          <label for="descripcion" class="form-label" name="descripcion">Descripción</label>
          <input class="form-control" id="descripcion" name="descripcion" type="text">
        </div>
        <div class="mb-3">
          <label for="precio" class="form-label" name="precio">Precio</label>
          <input class="form-control" id="precio" name="precio" type="text">
        </div>
        
        <div class="mb-3">
          <label for="categoria" class="form-label" name="categoria">Categoria</label>
          <select name="categoria"> 
          <c:forEach items="${categorias}" var="catTemp">
          	<option value="${catTemp.getId()}"> ${catTemp.getNombre() }</option>
          </c:forEach>
          </select>
        </div>
        
       <!--  
        <div class="input-group mb-3">
          <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Categoría</button>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </div>
        -->
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>

</body>
</html>