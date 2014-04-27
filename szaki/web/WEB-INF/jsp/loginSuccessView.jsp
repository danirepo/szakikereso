<%-- 
    Document   : loginSuccessView
    Created on : 2014.04.27., 17:47:43
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
        
        <h1>Welcome</h1>
        
        <c:out value="${loggedUser}" />
        <c:out value="${login}" />
        <a href="kereses.htm">Vissza</a>
    </body>
</html>
