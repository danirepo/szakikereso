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
        <a href="<c:url value="/userModify.htm"/>">Felhasználók</a> | <a href="<c:url value="/szakiModify.htm"/>">Szakemberek</a>
        <h1>Szakemberek</h1>
        <c:forEach items="${listOfSzaki}" var="szaki">
            <form:form commandName="szakiModifyCommand" method="POST">
                <p><c:out value="${szaki.lastName}"/> <c:out value="${szaki.firstName}"/></p>
                <spring:bind path="email">
                    <input type="hidden" name="${status.expression}" value="<c:out value="${szaki.email}"/>" >                    
                </spring:bind>
                    <input type="submit" value="Törlés">
            </form:form>
                    <br>
        </c:forEach>
    </div>
    <%@include file="footer.jsp" %>