<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"
    crossorigin="anonymous">
<title>JSP Page</title>
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
                    <a class="nav-link" href="listarProductoController">Listar</a> 
                    <a class="nav-link" href="agregarProductoController">Agregar Nuevo</a> 
                    <a class="nav-link" href="homeController">logout</a>
                </div>
            </div>
        </div>
    </nav>
    <div class="container">
        <h1>Personas</h1>
        <a class="btn btn-success" href="agregarProductoController">Agregar
            Nuevo</a> <br> <br>
        <table class="table table-bordered table-dark">
            <thead>
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">NOMBRE</th>
                    <th class="text-center">DESCRIPCION</th>
                    <th class="text-center">PRECIO</th>
                    <th class="text-center">CATEGORIA</th>
                    <th class="text-center">ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${listaProductoCategoria.size() == 0}">
                    <td colspan="6">No hay productos que mostrar</td>
                </c:if>
                <c:forEach items="${listaProductoCategoria}" var="var">
                    <tr>
                        <td class="text-center"><c:out value="${var.getProducto().getIdProducto()}"></c:out></td>
                        <td class="text-center"><c:out value="${var.getProducto().getNombreProducto()}"></c:out></td>
                        <td class="text-center"><c:out value="${var.getProducto().getDescripcionProducto()}"></c:out></td>
                        <td class="text-center"><c:out value="${var.getProducto().getPrecioProducto()}"></c:out></td>
                        <td class="text-center"><c:out value="${var.getCategoria().getNombre()}"></c:out></td>
                        <td class="text-center"><a class="btn btn-warning"
                            href="modificarProducto?id_producto=${var.getProducto().getIdProducto()}">Editar</a> <a
                            class="btn btn-danger"
                            href="eliminarProducto?id_producto=${var.getProducto().getIdProducto()}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>