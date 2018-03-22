<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practica1.4</title>
</head>
<body>
<h1>Bienvenido a la practica1.4 de Spring</h1>
<h2>Control de acceso</h2>
<form action="Servlet1" method=post>
Name: <input type=text name=username>
<br>
Password: <input type=password name= pass>
<br>
<input type=submit value=Iniciar>
</form>

</body>
</html>