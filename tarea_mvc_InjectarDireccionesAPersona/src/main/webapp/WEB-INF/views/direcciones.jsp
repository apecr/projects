<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Detalle de direcciones de ${persona.nombre}</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Lista de Direcciones</h1>
		</div>
		<h2>
			<span class="label table-striped label-primary">Detalle de
				direcciones de ${persona.nombre}</span>
		</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Calle</th>
					<th>Numero</th>
					<th>Ciudad</th>
					<th>País</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item"
					items="${persona.direcciones.listaDirecciones}">
					<tr>
						<td>${item.calle}</td>
						<td>${item.numero}</td>
						<td>${item.ciudad}</td>
						<td>${item.pais}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty persona.direcciones.listaDirecciones}">
					<tr>
						<td colspan="5">No hay direcciones</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<c:choose>
            <c:when test="${not empty persona}">
                <a href="persona" class="btn btn-info">Detalle ${persona.nombre}</a>
            </c:when>
            <c:otherwise>
                <a href="persona" class="btn btn-info">Persona</a>
            </c:otherwise>
        </c:choose>
        <a href="inicio" class="btn btn-info">Inicio</a>
	</div>

</body>
</html>
