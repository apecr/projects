<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Detalle usuarios</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				Tarea del modulo 4. Pagina con el detalle del usuario
			</h1>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Detalle del usuario</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">

						<table class="table table-striped table-hover table-bordered"
							style="width: 800px;">
							<tbody>
								<tr>
									<td>Nombre:</td>
									<td>${userModel.nombre}</td>
								</tr>
								<tr>
									<td>Apellido:</td>
									<td>${userModel.apellido}</td>
								</tr>
								<tr>
									<td>Email:</td>
									<td>${userModel.email}</td>
								</tr>
								<tr>
									<td>Username:</td>
									<td>${userModel.userName}</td>
								</tr>
								<tr>
									<td>Clave (no se debe mostrar):</td>
									<td>${userModel.clave}</td>
							</tbody>
						</table>
						<a class="btn btn-default"
							href="<%=request.getContextPath()%>/usuario" role="button">Volver</a>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>

