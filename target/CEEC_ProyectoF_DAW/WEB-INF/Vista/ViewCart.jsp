<%@ page import="java.util.LinkedList" %>
<%@ page import="Modelo.Carrito_Cliente_Productos_Beans" %>
<%@ page import="Modelo.Productos_Beans" %><%--
  Created by IntelliJ IDEA.
  User: cec19
  Date: 5/10/2022
  Time: 6:49 PM
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
    <div id="MainCart" style="height: 85vh; width: 100vw; background: cornsilk">
    <jsp:useBean id="CarritoProducto" scope="page" class="Modelo.Carrito_Cliente_Productos_Beans"></jsp:useBean>
    <jsp:useBean id="Detalles_Talla" class="Modelo.Detalle_Producto_Beans" ></jsp:useBean>
    <div id="singleColumn">
        <c:choose>
            <c:when test="${sessionScope.ListaProductos.size() == 0}">
                <p class="categoryText" style="text-align: center"> No tiene ningun Producto en el carrito!!! </p>
            </c:when>
            <c:otherwise>
                <div class="categoryText" style="text-align: center"> Tu carrito contiene ${sessionScope.ListaProductos.size()} Productos </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="categoryRightColumn" style="width: 100vw">
        <table id="productTable" style="width: 100vw">
            <% double total=0; %>
            <tr>
                <th>Imagen</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Talla</th>
            </tr>
            <% for (Carrito_Cliente_Productos_Beans i:(LinkedList<Carrito_Cliente_Productos_Beans>) session.getAttribute("ListaProductos")){%>
            <% Carrito_Cliente_Productos_Beans productoid = i;
                Productos_Beans productoDetalle = new Productos_Beans();
                productoDetalle = productoDetalle.getProducto(productoid.getID_Producto());
                total += productoid.getCantidad() * productoid.getPrecio_Carrito();%>


            <tr class="lightCorn">
                <td>
                    <img class="ImgProduct " src="${pageContext.request.contextPath}/Img/<%=productoDetalle.getImg()%>"
                         alt="">
                </td>
                <td>
                    <%=productoDetalle.getNombre()%>
                </td>
                <td>
                    <br>
                    <span class="smallText"><%=productoDetalle.getDescripcion()%></span>
                </td>
                <td>
                    <%=productoid.getCantidad()%>
                </td>
                <td>
                        <%=productoid.getPrecio_Carrito()%> $
                </td>
                <td>
                    <%=Detalles_Talla.searchTalla(i.getDetalle_Del_Producto())%>
                </td>
                <td>
                    <form action="updateCart" method="post">
                        <input type="hidden"
                                name="Detalle_Producto"
                                id="Detalle_Producto"
                                value="<%=productoid.getDetalle_Del_Producto()%>">
                        <input type="hidden"
                               name="productId"
                               id="productId"
                               value="<%=productoid.getID_Producto()%>">
                        <input type="number"
                               name="productQuantity"
                               id="productQuantity"
                               value="<%=productoid.getCantidad()%>"
                               min="0">
                        <input type="submit"
                               value="Modificar Carrito">
                    </form>
                </td>
                <% } // END FOR %>
            </tr>
        </table>
        <div class="categoryText" style="text-align: center; background: cornsilk; width: 100vw">
            Total Calculado: <%=total%>
        </div>
    </div>
        <form action="checkout" method="get">
            <input type="hidden"
                   name="total_Carrito"
                   id="total_Carrito"
                   value="<%=total%>">
            <input type="submit"
                   style="float: initial "
                   value="Proceder a comprar">
        </form>
        <form action="index.jsp" method="get">
            <input type="submit"
                   style="float: left"
                   value="Regresar">
        </form>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</body>
</html>
