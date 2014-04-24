<%-- 
    Document   : userRegistrationView
    Created on : 2014.04.24., 20:20:08
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
        <spring:nestedPath path="userRegistration">
            <form:form commandName="userRegistration" method="POST">
                Vezetéknév:
                <spring:bind path="lastName">
                    <input type="text" name="${status.expression}" value="${status.value}" />
                </spring:bind>
                Keresztnév:
                <spring:bind path="firstName">
                    <input type="text" name="${status.expression}" value="${status.value}" />
                </spring:bind>
                Email:
                <spring:bind path="email">
                    <input type="text" name="${status.expression}" value="${status.value}" />
                </spring:bind>
                Jelszó:
                <spring:bind path="password">
                    <input type="password" name="${status.expression}" value="${status.value}" />
                </spring:bind>
                <input type="submit" value="Regisztráció" />
            </form:form>
        </spring:nestedPath>
    </body>
</html>
