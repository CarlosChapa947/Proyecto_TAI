<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/13/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./CSS/Test_Style.css">
    <title>Carrito</title>
</head>
<body>
    <jsp:include page="Header.jsp"></jsp:include>
  <div id="MainCheckOut" style="height: 85vh; width: 100vw; background: cornsilk">
<div id="singleColumn">
    <h2>Detalles de Orden</h2>

    <p>Detalles</p>

    <form id="checkoutForm" action="purchase" method="post">
        <table id="checkoutTable">
            <tr>
                <td><label for="name">Nombre Cliente</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="name"
                           name="name"
                           value="${sessionScope.currentSessionUser.getNombre()} ${sessionScope.currentSessionUser.getApellido_P()}">
                </td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${sessionScope.currentSessionUser.getEmail()}">
                </td>
            </tr>
            <tr>
                <td><label for="phone">Telefono</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${sessionScope.currentSessionUser.getTelefono()}"/>
                </td>
            </tr>
            <tr>
                <td><label for="Codigo-Postal">Codigo Postal</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="Codigo-Postal"
                           name="Codigo-Postal"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td><label for="address">Direccion</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address"
                           name="address"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td><label for="Proveedor">Institucion Bancaria</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="Proveedor"
                           name="Proveedor"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td><label for="creditcard">Num Cuenta</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="creditcard"
                           name="creditcard"
                           class="creditcard"
                           value="">
                </td>
            </tr>
            <tr>
                <td><label for="Expiracion">Expiracion</label></td>
                <td class="inputField">
                    <input type="month"
                           size="31"
                           maxlength="19"
                           id="Expiracion"
                           name="Expiracion"
                           value="">
                </td>
            </tr>
            <input type="hidden"
                    id="Tipo-Pago"
                    name="Tipo-Pago"
                    value="Electronico">
            <input type="hidden"
                   id="total_Final"
                   name="total_Final"
                   value="${requestScope.total + (requestScope.total / 100)}">
            <tr>
                <td colspan="2">
                    <input type="submit" value="Confirmar">
                </td>
            </tr>
        </table>
    </form>

    <div id="infoBox">

        <table id="priceBox">
            <tr>
                <td>Suma Carrito</td>
                <td class="checkoutPriceColumn">
                    <fmt:formatNumber type="currency" currencySymbol="$" value="${requestScope.total}"/></td>
            </tr>
            <tr>
                <td>Envio</td>
                <td class="checkoutPriceColumn">
                    <fmt:formatNumber type="currency" currencySymbol="$" value="${requestScope.total / 100}"/></td>
            </tr>
            <tr>
                <td class="total">Total</td>
                <td class="total checkoutPriceColumn">
                    <fmt:formatNumber type="currency" currencySymbol="$" value="${requestScope.total + (requestScope.total / 100)}"/></td>
            </tr>
        </table>
    </div>
</div>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
