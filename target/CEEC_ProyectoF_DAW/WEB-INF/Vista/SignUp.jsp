<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/8/2022
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./CSS/Test_Style.css">
    <title>Sign Up Page</title>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>
    <div id="checkoutTable" style="background-position: center; width: 100%; height: 80%">
    <form action="SignUser" method="post">

        <label for="Nombres">Ingrese su Nombre</label><br>
        <input type="text" id="Nombres" class="inputField" name="Nombres"/><br>

        <label for="APaterno">Ingrese su Apellido Paterno</label><br>
        <input type="text" id="APaterno" class="inputField" name="APaterno"/><br>

        <label for="AMaterno">Ingrese su Apellido Materno</label><br>
        <input type="text" id="AMaterno" class="inputField" name="AMaterno"/><br>

        <label for="email">Ingrese su correo electronico</label><br>
        <input type="text" id="email" class="inputField" name="email"/><br>

        <label for="password">Ingrese su contraseña</label><br>
        <input type="password" id="password" class="inputField" name="password"/><br>

        <input type="submit" value="Registrarme">

    </form>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
