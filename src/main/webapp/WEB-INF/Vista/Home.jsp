
<%@ page import="java.util.LinkedList" %>
<%@page import="Modelo.Categorias_Beans" %>
<%@page import="Datos.Categorias_DAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
<jsp:useBean id="p" class="Modelo.Categorias_Beans"></jsp:useBean>
<div id="Main">
    <div id="Header">
    <jsp:include page="/WEB-INF/Vista/Header.jsp"></jsp:include>

        <img src="${pageContext.request.contextPath}../../Img/<%="Adidas2.jpg"%>" id="Logo">

    </div>

    <div id="IndexLeftColumn">
        <div id="WelcomeDiv">
            <img alt="" src="${pageContext.request.contextPath}../../Img/<%="LeftBanner1.jpg"%>" id="LeftBanner">
        </div>

    </div>

    <div id="IndexRightColumn">
        <% Categorias_DAO cate_DAO = null;
            cate_DAO = new Categorias_DAO();
            LinkedList<Categorias_Beans> categorias = cate_DAO.getCategorias();
        %>
        <% int i=0; %>
        <% i=0; %>
        <c:forEach var="z" items="<%=categorias%>">
            <div class="CategoryBox">
                <a href="Categoria?<%=categorias.get(i).getID_Categorias()%>">
                    <div class="categoryText"><%= categorias.get(i).getNombre()%></div>
                    <img src="${pageContext.request.contextPath}../../Img/<%=categorias.get(i).getImageName()%>" class="CategoryImg">
                </a>

            </div>
            <% i++;%>
        </c:forEach>
    </div>
    <jsp:include page="/WEB-INF/Vista/Footer.jsp"></jsp:include>
</div>
</body>
</html>