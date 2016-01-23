<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Bienvenidos!</h1>

	<P>La fecha actual es ${serverTime}.</P>
	<P>Hay una persona: ${persona.nombre}</P>
</body>
</html>
