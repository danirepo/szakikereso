<%-- 
    Document   : profile
    Created on : 2014.04.29., 13:01:50
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
    <%@include file="header.jsp" %>

    <div class="content sixteen columns">
        <h1>Title : ${title}</h1>
        <h1>Message : ${message}</h1>


        <c:forEach items="${listOfUser}" var="user">
            <c:if test="${user.email == pageContext.request.userPrincipal.name}">
                <p>Ez az emailje: <c:out value="${user.email}" /></p>
            </c:if>
        </c:forEach>


    </div>
    <%@include file="footer.jsp" %>