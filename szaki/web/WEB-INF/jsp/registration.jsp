<%-- 
    Document   : regisztracio
    Created on : 2014.04.28., 13:56:43
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
    <%@include file="header.jsp" %>
    <h1>Regisztráció</h1>
    <p>Ha Ön szakember akkor válassza a <a href="<c:url value="/szakiregisztracio.htm" />">szakember regisztrációt</a></p>
    <p>Ha Ön értékelni szeretné a szakemberek válassza a <a href="<c:url value="/regisztracio.htm" />" >felhasználó regisztrációt</a></p>
    <%@include file="footer.jsp" %>
