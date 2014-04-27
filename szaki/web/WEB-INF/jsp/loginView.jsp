<%-- 
    Document   : loginView
    Created on : 2014.04.27., 17:43:12
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="source.jsp" %>
    </head>
    <body>
        <c:out value="${loggedUser}" />
        <spring:nestedPath path="login">
            <form:form commandName="loginCN" method="POST" name="login">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                E-mail:
                <form:input path="email"/><br/>
                Jelszó
                <form:password path="password"/><br/>
                <input type="submit" value="Belépés" />
            </form:form>
        </spring:nestedPath>
    </body>
</html>
