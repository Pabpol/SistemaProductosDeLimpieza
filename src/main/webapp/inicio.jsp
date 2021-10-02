<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

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
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container-fluid px-0 mx-1 mt-4">
		<div class="row">
			<div class="col-sm-8">
				<div class="d-flex justify-content-between"><h1 class="mb-3">Lista de productos</h1><span><a class="${displayVolver}" href="/ProductosDeLimpieza/Inicio"><button class="btn btn-primary">Volver</button></a></span></div>
				
				
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
							<th scope="col">Precio</th>
							<th scope="col">Descripción</th>
							<th scope="col">Categoría</th>
							<th scope="col">Modificar/Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producto" items="${productos}">
							<tr>
								<th scope="row"><c:out value="${producto.getIdProducto()}"></c:out>
								</th>
								<td><c:out value="${producto.getNombreProdcuto()}"></c:out></td>
								<td><c:out value="${producto.getPrecioProducto()}"></c:out></td>
								<td><c:out value="${producto.getDescripcionProducto()}"></c:out></td>
								<td><c:out
										value="${producto.getCategoria().getNombreCategoria()}"></c:out></td>
								<td class="d-flex justify-content-evenly"><a
									href="/ProductosDeLimpieza/IrModificarProducto?idProducto=${producto.getIdProducto()}"><i
										class="fas fa-pen"></i></a> <a
									href="/ProductosDeLimpieza/EliminarProducto?idProducto=${producto.getIdProducto()}"><i
										class="fas fa-trash-alt text-danger"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-3 text-center ms-5 ">
				<h3 class="mb-4">Agregar Producto</h3>
				<form action="/ProductosDeLimpieza/AgregarProducto" method="post">
					<div class="mb-3 text-start">
						<label class="form-label">Nombre Producto</label> <input
							type="text" class="form-control" name="nombreProducto">
					</div>
					<div class="mb-3 text-start">
						<label class="form-label ">Precio</label> <input type="text"
							class="form-control" name="precio">
					</div>
					<div class="mb-3 text-start">
						<label class="form-label">Descripción</label> <input type="text"
							class="form-control" name="descripcion">
					</div>
					<div class="mb-3 text-start">
						<label class="form-label">Categoría</label> 							
						<select class="form-select" id="inputGroupSelect01" name="categoria">
							<option value="" disabled selected hidden>Elegir</option>
							<option value="Detergente líquido">Detergente líquido</option>
							<option value="Detergente en polvo">Detergente en polvo</option>
						</select>

					</div>
					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-primary">Agregar</button>
					</div>


				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8">				
			
				<form class="d-flex" action="/ProductosDeLimpieza/BuscarProducto" method="post">
					<input class="form-control me-2" type="search" placeholder="Buscar producto por id"
						aria-label="Buscar" name="idProductoBuscar">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form></div>
		</div>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>

</html>