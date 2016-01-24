<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h1>Bienvenidos!</h1>

	<P>La fecha actual es ${serverTime}.</P>
	<c:choose>
		<c:when test="${not empty persona}">
			<a href="persona" class="btn btn-info">Detalle ${persona.nombre}</a>
		</c:when>
		<c:otherwise>
			<a href="persona" class="btn btn-info">Persona</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
