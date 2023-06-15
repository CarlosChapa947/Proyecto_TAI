<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 6/11/2022
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<html>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
        <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
        <META HTTP-EQUIV="Expires" CONTENT="0">
        <link rel="stylesheet" type="text/css" href="./CSS/Test_Style.css">
        <title>My Company</title>
</head>
<body>
        <jsp:include page="/WEB-INF/Vista/Header.jsp"></jsp:include>
        <jsp:useBean id="productoInventario" class="Modelo.Productos_Beans" ></jsp:useBean>
        <jsp:useBean id="CompraSeleccionada" class="Modelo.Orden_Cliente_Beans"></jsp:useBean>
        <jsp:useBean id="DetalleProducto" class="Modelo.Detalle_Producto_Beans"></jsp:useBean>
        <c:set var="CompraSeleccionada" value="${requestScope.ordenSeleccionada}"></c:set>
        <div id="categoryLeftColumn">

                <c:forEach var="Compra" items="${requestScope.listaOrdenes}">
                        <c:choose>
                                <c:when test="${Compra.getID_Orden_Cliente() == pageContext.request.queryString}">
                                        <div class="categoryButton" id="selectedCategory">
                        <span class="categoryText">
                                        ${Compra.getID_Orden_Cliente()}
                        </span>
                                        </div>
                                </c:when>
                                <c:otherwise>
                                        <a href="purchaseHistory?${Compra.getID_Orden_Cliente()}" class="categoryButton">
                                                <div class="categoryText">
                                                                ${Compra.getID_Orden_Cliente()}
                                                </div>
                                        </a>
                                </c:otherwise>
                        </c:choose>
                </c:forEach>

        </div>

        <div id="categoryRightColumn">
                <table id="productTable">

                        <tr class="lightCorn">
                                <th>Imagen</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Modelo</th>
                        </tr>

                        <c:forEach var="ordenProducto" items="${requestScope.listaOrdenProductos}" varStatus="iter">
                                <c:set var="producto" value="${productoInventario.getProducto(ordenProducto.getID_Producto())}"></c:set>

                                <tr class="lightCorn">
                                        <td>
                                                <img class="ImgProduct" src="${pageContext.request.contextPath}/Img/${producto.getImg()}">
                                        </td>
                                        <td>
                                                        ${producto.getNombre()}
                                                <br>
                                        </td>
                                        <td>
                                                <span class="smallText">${ordenProducto.getCantidad()}</span>
                                        </td>
                                        <td>
                                                       Total del Producto: ${ordenProducto.getPrecio_Final() * ordenProducto.getCantidad()} $
                                        </td>
                                        <td>
                                                ${DetalleProducto.searchTalla(ordenProducto.getDetalle_Del_Producto())}
                                        </td>
                                </tr>
                        </c:forEach>
                        <tr class="lightCorn">
                                Total Final de la Compra ${CompraSeleccionada.getTotal()} $
                                Status: ${CompraSeleccionada.getStatus()}
                        </tr>
                </table>
        </div>
        <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
