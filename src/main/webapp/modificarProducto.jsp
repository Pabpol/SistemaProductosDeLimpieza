<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Sesión de ${userName}</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Perfil</a></li>
				</ul>
			</div>
		</div>
	</nav>

<div class="container-fluid mx-auto">
	<div class="col">
		<h1 class="mb-3">Modificar Producto</h1>
		<form action="/ProductosDeLimpieza/ModificarProducto" method="post">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Precio</th>
					<th scope="col">Descripción</th>
					<th scope="col">Categoría</th>
					<th scope="col">Modificar</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
					
						<th scope="row"><input readonly type="text" class="form-control" name="idProducto" value="<c:out value="${producto.getIdProducto()}"></c:out>">
						</th>
						<td> <input type="text" class="form-control" name="nombreProducto" value="<c:out value="${producto.getNombreProdcuto()}"></c:out>"> </td>
						<td><input type="text" class="form-control" name="precio" value="<c:out value="${producto.getPrecioProducto()}"></c:out>"> </td>
						<td><input type="text" class="form-control" name="descripcion" value="<c:out value="${producto.getDescripcionProducto()}"></c:out>"> </td>
						<td>
						<select class="form-select" id="inputGroupSelect01" name="categoria">
							<%-- <option value="" disabled selected hidden><c:out value="${producto.getCategoria().getNombreCategoria()}"></c:out></option> --%>
									
						    <option value="Detergente en polvo">Detergente en polvo</option>
							<option value="Detergente líquido">Detergente líquido</option>
						</select> </td>
						<td class="d-flex justify-content-evenly"><button class="btn btn-primary" type="submit">Modificar</button></td>
							
					</tr>
				
			</tbody>
		</table>
		</form>
	</div>
</div>
</body>
</html>