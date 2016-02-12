<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h1>
		<fmt:message key="listado.title" />
	</h1>
</div>

<p>
	<a class="btn btn-default" href="<c:url value="/usuario"/>"
		role="button"><fmt:message key="text.agregar.usuario" /> (+)</a>
</p>
<div class="panel panel-primary">
	<div class="panel-heading">
		<fmt:message key="listado.title" />
	</div>
	<div class="panel-body">
		<div class="container">
			<div class="row">

				<table style="width: 700px;"
					class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>#</th>
							<th><fmt:message key="label.nombre" /></th>
							<th><fmt:message key="label.apellido" /></th>
							<th><fmt:message key="label.email" /></th>
							<th><fmt:message key="label.username" /></th>
							<th><fmt:message key="label.clave" /></th>
							<th><fmt:message key="text.editar" /></th>
							<th><fmt:message key="text.eliminar" /></th>
						</tr>
					</thead>
					<tbody>
					    <c:if test="${not empty listadoUsuarios}">
						<c:forEach items="${listadoUsuarios}" var="usuario">
							<tr>
								<td><c:out value="${usuario.id}" /></td>
								<td><c:out value="${usuario.nombre}" /></td>
								<td><c:out value="${usuario.apellido}" /></td>
								<td><c:out value="${usuario.email}" /></td>
								<td><c:out value="${usuario.userName}" /></td>
								<td><c:out value="${usuario.clave}" /></td>
								<td><a class="btn-xs btn-primary"
									href="<c:url value="/usuario?id=${usuario.id}"/>"><fmt:message key="text.editar" /></a></td>
								<td><a class="btn-xs btn-danger"
									onclick="return confirm('Esta seguro?');"
									href="<c:url value="/usuario/eliminar.htm/${usuario.id}"/>"><fmt:message key="text.eliminar" /></a></td>
							</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>