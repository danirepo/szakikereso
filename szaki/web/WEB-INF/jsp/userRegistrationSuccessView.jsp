<%-- 
    Document   : userRegistrationSuccessView
    Created on : 2014.04.24., 20:54:38
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="userRegistrationSuccessView.title" /></title>
        <%@include file="source.jsp" %>
    </head>

    <%@include file="header.jsp" %>
    <h1>Sikeres regisztráció</h1>
    <a href="<c:url value="/index.htm" />">Kezdőoldal</a>
    <%@include file="footer.jsp" %>

