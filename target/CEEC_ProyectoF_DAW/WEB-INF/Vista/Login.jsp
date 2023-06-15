<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/8/2022
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./CSS/Test_Style.css">
    <title>Login Page</title>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>
    <div id="checkoutTable" style="background-position: center; width: 100%; height: 80%">
    <form action="LoginUser" method="post">

        <label for="email">Ingrese su correo electronico</label><br>
        <input type="text" id="email" class="inputField" name="email" /><br>

        <label for="password">Ingrese su contraseña</label><br>
        <input type="password" id="password" class="inputField" name="password"/><br>

        <input type="submit" value="Iniciar Sesion">

    </form>
        <a href="SignUp">
            <span class="inputField">¿No tienes una cuenta? Registrate Ahora!!</span>
        </a>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
