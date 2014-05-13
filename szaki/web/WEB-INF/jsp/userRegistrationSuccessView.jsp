<%-- 
    Document   : userRegistrationSuccessView
    Created on : 2014.04.24., 20:54:38
    Author     : Dani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="userRegistrationSuccessView.title" /></title>
        <%@include file="source.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Sikeres regisztráció</h1>
        <a href="<c:url value="/regisztracio.htm" />">Vissza</a>
        <%@include file="footer.jsp" %>
    </body>
</html>
