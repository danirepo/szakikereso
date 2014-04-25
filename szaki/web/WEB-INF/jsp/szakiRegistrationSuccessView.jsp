<%-- 
    Document   : szakiRegistrationSuccessView
    Created on : 2014.04.25., 13:21:28
    Author     : Dani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sikeres szakember regisztráció</h1>
        <c:forEach items="${profession.professionList}" var="prof">
            <p><c:out value="${prof}"/></p>
        </c:forEach>
    </body>
</html>
