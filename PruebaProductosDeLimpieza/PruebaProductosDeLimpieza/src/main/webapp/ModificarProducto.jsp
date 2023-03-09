<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <title>Modificar Producto</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
           
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link" href="listarProductoController">Listar</a>
                    <a class="nav-link" href="agregarProductoController">Agregar Producto</a>
                </div>
            </div>
        </div>
    </nav>
        <div class="container">
            <div class="col-lg-6">
             
            <h1>Modificar Producto</h1>
            <form action="modificarProducto" method="POST">
            	<input type="hidden" name="id_producto" value="${producto.getIdProducto()}">
                Nombre:<br>
                <input class="form-control" type="text" name="nombre_producto" value="${producto.getNombreProducto()}"><br>
                Descripcion: <br>
                <input class="form-control" type="text" name="descripcion_producto" value="${producto.getDescripcionProducto()}"><br>
                Precio: <br>
                <input class="form-control" type="text" name="precio_producto" value="${producto.getPrecioProducto()}"><br>
                Categoria: <br>
                <select name="id_categoria">
                	<c:forEach items="${categorias}" var="categoria">
                		<option value="${categoria.getId()}" ${categoria.getId() == producto.getIdCategoria() ? 'selected': ''}>
                			${categoria.getNombre()}</option>
                	</c:forEach>
                </select>
                
                
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                <a href="listarProducto">Regresar</a>
            </form>
          </div>
        </div>
    </body>
</html>