<%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/3/2022
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Test_Style.css">
    <title>Title</title>
</head>
<body>
    <jsp:include page="/WEB-INF/Vista/Header.jsp"></jsp:include>
    <jsp:useBean id="Detalle" class="Modelo.Detalle_Producto_Productos" ></jsp:useBean>
    <jsp:useBean id="Detalles_Talla" class="Modelo.Detalle_Producto_Beans" ></jsp:useBean>

    <div id="categoryLeftColumn">

        <c:forEach var="categoria" items="${applicationScope.appCategorias}">
            <c:choose>
                <c:when test="${categoria.getID_Categorias() == pageContext.request.queryString}">
                    <div class="categoryButton" id="selectedCategory">
                        <span class="categoryText">
                            ${categoria.getNombre()}
                        </span>
                    </div>
                </c:when>
                <c:otherwise>
                    <a href="Categoria?${categoria.getID_Categorias()}" class="categoryButton">
                        <div class="categoryText">
                                ${categoria.getNombre()}
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
                <th>Precio</th>
                <th>Modelo</th>
            </tr>

            <c:forEach var="producto" items="<%=request.getAttribute(\"Test2\")%>" varStatus="iter">

            <tr class="lightCorn">
                <td>
                    <img class="ImgProduct" src="${pageContext.request.contextPath}/Img/${producto.getImg()}">
                </td>
                <td>
                        ${producto.getNombre()}
                    <br>
                    <span class="smallText">${producto.getDescripcion()}</span>
                </td>
                <td>
                        ${producto.getPrecio_Unitario()} $
                </td>
                <td>
                    <form action="addToCart" method="post">
                        <input  name="productQuantity" type="number" min="1" value="1">
                        <select name="Detalle_Producto">
                            <c:forEach var="Detalle_Producto_Productos" items="${Detalle.getAllDetallesOfProducto(producto.getID_Productos())}">
                                <option value="${Detalle_Producto_Productos.getFK_Detalle_Producto()}">${Detalles_Talla.searchTalla(Detalle_Producto_Productos.getFK_Detalle_Producto())}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden"
                               name="productId"
                               id="productId"
                               value="${producto.getID_Productos()}">
                        <input type="hidden"
                                name="CateID"
                                id="CateID"
                                value="${pageContext.request.queryString}">
                        <input type="submit"
                               value="Meter al carrito">
                    </form>
                </td>
            </tr>

        </c:forEach>

        </table>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
