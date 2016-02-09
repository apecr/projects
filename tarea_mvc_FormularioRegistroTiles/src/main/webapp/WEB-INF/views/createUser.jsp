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
<title>mvc_form_etiquetas</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
.error-campo {
	color: #ff0000;
}
</style>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				Formulario Spring <small> Etiquetas Form de Spring y
					Validaciones usando Anotaciones</small>
			</h1>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Crear Estudiante</div>
			<div class="panel-body">
				<div class="container">
					<div class="row">

						<form:form modelAttribute="userModel" action="usuario" method="post"
							cssClass="form-horizontal" role="form">
							<form:errors path="*" cssClass="alert alert-danger"
								cssStyle="width: 800px;" element="div" />

							<div class="form-group">
                                <form:label for="userName" path="userName"
                                    cssClass="col-sm-2 control-label">Username :</form:label>
                                <div class="col-sm-10">
                                    <form:input path="userName" style="width: 300px;"
                                        cssClass="form-control"
                                        cssErrorClass="form-control alert-danger" />
                                    <form:errors path="userName" cssClass="error-campo" />
                                </div>
                            </div>
							<div class="form-group">
								<form:label for="nombre" path="nombre"
									cssClass="col-sm-2 control-label">Nombre :</form:label>
								<div class="col-sm-10">
									<form:input path="nombre" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="nombre" cssClass="error-campo" />
								</div>
							</div>
							<div class="form-group">
								<form:label for="apellido" path="apellido"
									cssClass="col-sm-2 control-label">Apellido :</form:label>
								<div class="col-sm-10">
									<form:input path="apellido" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="apellido" cssClass="error-campo" />
								</div>
							</div>
							<div class="form-group">
                                <form:label for="email" path="email"
                                    cssClass="col-sm-2 control-label">Email :</form:label>
                                <div class="col-sm-10">
                                    <form:input path="email" style="width: 300px;"
                                        cssClass="form-control"
                                        cssErrorClass="form-control alert-danger" />
                                    <form:errors path="email" cssClass="error-campo" />
                                </div>
                            </div>
							<div class="form-group">
								<form:label for="clave" path="clave"
									cssClass="col-sm-2 control-label">Clave :</form:label>
								<div class="col-sm-10">
									<form:password path="clave" style="width: 300px;"
										cssClass="form-control"
										cssErrorClass="form-control alert-danger" />
									<form:errors path="clave" cssClass="error-campo" />
								</div>
							</div>



							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="submit" value="Crear Usuario"
										class="btn btn-primary" role="button" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>