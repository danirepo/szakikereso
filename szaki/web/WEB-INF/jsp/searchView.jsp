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
    <body>
        <%@include file="header.jsp" %>
        <c:out value="${login}" />
        <h1>Keresés!</h1>
        <c:out value="${loggedUser}" />
        <form:form commandName="searching" method="POST">
            Ország:
            <spring:bind path="country">
                <select name="${status.expression}">
                    <option value="Magyar" selected="selected">Magyar</option>
                    <option value="Svéd">Svéd</option>
                </select><br />
            </spring:bind>
            Megye:
            <spring:bind path="county">
                <select name="${status.expression}">
                    <option value="Baranya" selected="selected">Baranya</option>
                    <option value="Békés">Békés</option>
                </select><br />
            </spring:bind>
            Szakma:
            <%--<spring:bind path="*">                
                <c:forEach items="${listOfProfessions}" var="prof">                    
                    <form:checkbox path="profession" id="${prof.id}" value="${prof.id}" label="${prof.name}" />
                </c:forEach><br/>
            </spring:bind>--%>
            <spring:bind path="profession">
                <form:select path="profession">
                    <c:forEach items="${listOfProfessions}" var="prof">
                        <form:option value="${prof.id}"><c:out value="${prof.name}"/></form:option>
                    </c:forEach>
                </form:select>
            </spring:bind><br/>
            <input type="submit" value="keresés" />
        </form:form>
        <%@include file="footer.jsp" %>
    </body>
</html>
