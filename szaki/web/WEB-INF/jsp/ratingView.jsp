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
    <%@include file="header.jsp" %>
    <div class="content sixteen columns">
        <h1>Értékelés</h1>
        <form:form commandName="ratingCommand" method="post" id="rating">
            <label>Osztályzat:</label>
            <spring:bind path="mark">
                <input type="number" min="1" max="5" value="5" name="${status.expression}" />
            </spring:bind><br>
            <label>Leírás:</label>
            <spring:bind path="description">
                <textarea name="${status.expression}" placeholder="Leírás"></textarea>
            </spring:bind><br>
            <spring:bind path="sender">
                <input type="hidden" name="sender" value="${pageContext.request.userPrincipal.name}" />
            </spring:bind>
            <spring:bind path="szaki">
                <input type="hidden" name="szaki" class="szaki" />
            </spring:bind>
            <input type="submit" value="Küldés"/>
        </form:form>
    </div>
    <%@include file="footer.jsp" %>
