<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${titulo}</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="page-header">
		<h1>
			${titulo}: <small>Ejemplo de base datos Spring MVC usando
				HibernateTemplate</small>
		</h1>
	</div>
	<div class="container">
		<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
			<p>
				<a class="btn btn-default"
					href="<c:url value="/catalogo/form.htm"/>" role="button">Agregar
					Producto (+)</a>
			</p>
		</sec:authorize>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<c:out value="${titulo}" />
			</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">

						<table style="width: 700px;"
							class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<sec:authorize access="hasRole('ROLE_USER')">
										<th>Precio</th>
									</sec:authorize>
									<th>Cantidad</th>
									<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
										<th>Editar</th>
										<th>Eliminar</th>
									</sec:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${productos}" var="producto">
									<tr>
										<td><c:out value="${producto.id}" /></td>
										<td><c:out value="${producto.nombre}" /></td>
										<sec:authorize access="hasRole('ROLE_USER')">
											<td><c:out value="${producto.precio}" /></td>
										</sec:authorize>
										<td><c:out value="${producto.cantidad}" /></td>
										<sec:authorize access="hasRole('ROLE_SUPERVISOR')">
											<td><a class="btn-xs btn-primary"
												href="<c:url value="/catalogo/form.htm?id=${producto.id}"/>">editar</a></td>
											<td><a class="btn-xs btn-danger"
												onclick="return confirm('Esta seguro?');"
												href="<c:url value="/catalogo/eliminar.htm?id=${producto.id}"/>">eliminar</a></td>
										</sec:authorize>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<sec:authorize access="isAuthenticated()">
			<form id="logoutForm"
				action="${pageContext.request.contextPath}/logout" method="post">
				<input class="btn btn-warning" role="button" type="submit"
					value="Log out" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</sec:authorize>
	</div>
	<script type="text/javascript">
		function formSubmit() {
			$("#logoutForm").submit();
		}
	</script>
</body>
</html>