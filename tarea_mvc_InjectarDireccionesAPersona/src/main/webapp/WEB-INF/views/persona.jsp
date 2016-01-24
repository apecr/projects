<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:if test="${not empty persona}">
	<title>Detalle ${persona.nombre}</title>
</c:if>
<c:if test="${empty persona}">
	<title>Detalle sin persona</title>
</c:if>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Detalle de la persona</h1>
		</div>
		<h2>
			<span class="label table-striped label-primary">Detalle de la
				persona</span>
		</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Edad</th>
					<th>Peso</th>
					<th>Programador</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty persona}">
					<tr>
						<td>${persona.nombre}</td>
						<td>${persona.edad}</td>
						<td>${persona.peso}</td>
						<td>${persona.programador}</td>
					</tr>
				</c:if>
				<c:if test="${empty persona}">
					<tr>
						<td colspan="5">No hay persona</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<c:choose>
			<c:when test="${not empty persona}">
				<a href="direcciones" class="btn btn-info">Direcciones de
					${persona.nombre}</a>
			</c:when>
			<c:otherwise>
				<a href="direcciones" class="btn btn-info">Direcciones</a>
			</c:otherwise>
		</c:choose>
		<a href="inicio" class="btn btn-info">Inicio</a>
	</div>
</body>
</html>