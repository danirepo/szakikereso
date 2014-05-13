<%-- 
    Document   : ratingView
    Created on : 2014.05.10., 18:35:06
    Author     : Dani
--%>

<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="ratingView.title" /></title>
        <%@include file="source.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Értékelés</h1>
        <form:form commandName="ratingCommand" method="post">
            <spring:bind path="mark">
                <input type="number" min="1" max="5" name="${status.expression}" />
            </spring:bind>
            <spring:bind path="description">
                <textarea name="${status.expression}"></textarea>
            </spring:bind>
            <spring:bind path="sender">
                <input type="hidden" name="sender" value="${pageContext.request.userPrincipal.name}" />
            </spring:bind>
            <spring:bind path="szaki">
                <input type="hidden" name="szaki" class="szaki" />
            </spring:bind>
            <input type="submit" value="küldés"/>
        </form:form>
        <%@include file="footer.jsp" %>
    </body>
</html>
