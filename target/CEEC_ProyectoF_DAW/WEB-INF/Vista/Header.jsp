<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/2/2022
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<head>
    <link rel="stylesheet" type="text/css" href="./CSS/Test_Style.css">
</head>
<jsp:useBean id="User" class="Modelo.Clientes_Beans" scope="session"></jsp:useBean>
    <div id="WidgetBar">

        <div class="HeaderWidget">
            <a href="index.jsp">
                Inicio
            </a>
        </div>

        <div class="HeaderWidget">
            <c:choose>
                <c:when test="${sessionScope.currentSessionUser == null}">
                    <a href="Login">
                        Login
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="Logout">
                        Logout
                    </a>
                </c:otherwise>
            </c:choose>
        </div>

        <c:choose>
            <c:when test="${sessionScope.currentSessionUser != null}">
                <div class="HeaderWidget">
                    <a href="viewCart">
                        Carrito
                    </a>
                </div>

                <div class="HeaderWidget">
                    <a href="purchaseHistory">
                        Historial de Compras
                    </a>
                </div>
            </c:when>
        </c:choose>

    </div>