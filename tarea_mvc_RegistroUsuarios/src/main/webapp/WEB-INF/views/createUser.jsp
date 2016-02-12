<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h1>
		<fmt:message key="text.spring.form" />
		<small> <fmt:message key="header.detalle" /></small>
	</h1>
</div>

<div class="panel panel-primary">
	<div class="panel-heading"><fmt:message key="text.crear.estudiante" /></div>
	<div class="panel-body">
		<div class="container">
			<div class="row">

				<form:form modelAttribute="user" method="post"
					cssClass="form-horizontal" role="form">
					<form:errors path="*" cssClass="alert alert-danger"
						cssStyle="width: 800px;" element="div" />

					<div class="form-group">
						<form:label for="userName" path="userName"
							cssClass="col-sm-2 control-label">
							<fmt:message key="label.username" /> :</form:label>
						<div class="col-sm-10">
							<form:input path="userName" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="userName" cssClass="error-campo" />
						</div>
					</div>
					<div class="form-group">
						<form:label for="nombre" path="nombre"
							cssClass="col-sm-2 control-label">
							<fmt:message key="label.nombre" /> :</form:label>
						<div class="col-sm-10">
							<form:input path="nombre" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="nombre" cssClass="error-campo" />
						</div>
					</div>
					<div class="form-group">
						<form:label for="apellido" path="apellido"
							cssClass="col-sm-2 control-label">
							<fmt:message key="label.apellido" /> :</form:label>
						<div class="col-sm-10">
							<form:input path="apellido" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="apellido" cssClass="error-campo" />
						</div>
					</div>
					<div class="form-group">
						<form:label for="email" path="email"
							cssClass="col-sm-2 control-label">
							<fmt:message key="label.email" /> :</form:label>
						<div class="col-sm-10">
							<form:input path="email" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="email" cssClass="error-campo" />
						</div>
					</div>
					<div class="form-group">
						<form:label for="clave" path="clave"
							cssClass="col-sm-2 control-label">
							<fmt:message key="label.clave" /> :</form:label>
						<div class="col-sm-10">
							<form:password path="clave" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="clave" cssClass="error-campo" />
						</div>
					</div>



					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit"
								value="<fmt:message key="button.crear.usuario"/>"
								class="btn btn-primary" role="button" />
						</div>
					</div>
				</form:form>
				<a class="btn btn-default"
                    href="<%=request.getContextPath()%>/usuario/listado.htm" role="button"><fmt:message key="button.volver" /></a>
			</div>
		</div>
	</div>
</div>

