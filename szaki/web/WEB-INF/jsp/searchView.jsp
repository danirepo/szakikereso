<%-- 
    Document   : searchView
    Created on : 2014.04.26., 16:56:31
    Author     : Dani
--%>

<%@page import="com.szaki.domain.Login"%>
<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="searchView.title" /></title>
        <%@include file="source.jsp" %>
    </head>
    <%@include file="header.jsp" %>
    <div class="content sixteen columns">
        <h1>Keresés!</h1>
        <form:form commandName="searching" method="POST">
            <label>Ország:</label>
            <spring:bind path="country">
                <select name="${status.expression}">
                    <option value="Magyar" selected="selected">Magyar</option>
                    <option value="Svéd">Svéd</option>
                </select>
            </spring:bind>
            <label>Megye:</label>
            <spring:bind path="county">
                <select name="${status.expression}">
                    <option value="Baranya" selected="selected">Baranya</option>
                    <option value="Békés">Békés</option>
                </select>
            </spring:bind>
            <label>Szakma:</label>
            <%--<spring:bind path="*">                
                <c:forEach items="${listOfProfessions}" var="prof">                    
                    <form:checkbox path="profession" id="${prof.id}" value="${prof.id}" label="${prof.name}" />
                </c:forEach>
            </spring:bind>--%>
            <spring:bind path="profession">
                <form:select path="profession">
                    <c:forEach items="${listOfProfessions}" var="prof">
                        <form:option value="${prof.id}"><c:out value="${prof.name}"/></form:option>
                    </c:forEach>
                </form:select>
            </spring:bind>
            <input type="submit" value="keresés" />
        </form:form>
    </div>
    <%@include file="footer.jsp" %>
