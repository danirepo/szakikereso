<%-- 
    Document   : ratingSuccessView
    Created on : 2014.04.30., 20:26:37
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${rating}" var="rat">
            <c:out value="${rat.description}"/>
        </c:forEach>
    </body>
</html>
