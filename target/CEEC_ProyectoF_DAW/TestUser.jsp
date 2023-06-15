<%@ page import="Modelo.Clientes_Beans" %>
<%@ page import="Modelo.Carrito_Cliente_Beans" %><%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/8/2022
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% Clientes_Beans currentUser = (Clientes_Beans) (session.getAttribute("currentSessionUser"));%>
    <% Carrito_Cliente_Beans currentCart = (Carrito_Cliente_Beans) (session.getAttribute("currentCart"));%>
    Welcome <%= currentUser.getNombre() + " " + currentUser.getApellido_P() %>
    Shopping <%= currentCart.getID_Carrito()%>

</body>
</html>
