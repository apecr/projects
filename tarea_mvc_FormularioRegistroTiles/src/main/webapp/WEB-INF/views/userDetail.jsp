<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h1><fmt:message key="text.spring.form.small" /></h1>
</div>

<div class="panel panel-primary">
	<div class="panel-heading"><fmt:message key="text.detalle.usuario" /></div>
	<div class="panel-body">
		<div class="container">
			<div class="row">

				<table class="table table-striped table-hover table-bordered"
					style="width: 800px;">
					<tbody>
						<tr>
							<td><fmt:message key="label.nombre" />:</td>
							<td>${userModel.nombre}</td>
						</tr>
						<tr>
							<td><fmt:message key="label.apellido" />:</td>
							<td>${userModel.apellido}</td>
						</tr>
						<tr>
							<td><fmt:message key="label.email" />:</td>
							<td>${userModel.email}</td>
						</tr>
						<tr>
							<td><fmt:message key="label.username" />:</td>
							<td>${userModel.userName}</td>
						</tr>
						<tr>
							<td><fmt:message key="label.clave" />:</td>
							<td>${userModel.clave}</td>
					</tbody>
				</table>
				<a class="btn btn-default"
					href="<%=request.getContextPath()%>/usuario" role="button"><fmt:message key="button.volver" /></a>

			</div>
		</div>
	</div>
</div>


