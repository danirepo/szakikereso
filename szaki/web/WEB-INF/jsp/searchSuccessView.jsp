<%-- 
    Document   : searchSuccessView
    Created on : 2014.04.26., 19:22:50
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
        <h1>Találati lista</h1>
        <c:out value="${loggedUser}" />
        <c:forEach items="${foundList}" var="item">
            <p><c:out value="${item.lastName}" />&nbsp;<c:out value="${item.firstName}" />, <c:if test="${item.profession != 'null'}"><c:out value=" ${item.profession}"/></c:if> 
                <c:if test="${item.profession2 != 'null'}">,<c:out value="${item.profession2}"/></c:if> <c:if test="${item.profession3 != 'null'}">, <c:out value="${item.profession3}"/></c:if></p>
            </c:forEach>
            <p><c:out value="${notFound}"/></p>
    </body>
</html>
