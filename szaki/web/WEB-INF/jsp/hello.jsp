<%-- 
    Document   : hello
    Created on : 2014.04.29., 12:30:18
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
        <h1>title: ${title}</h1>
        <h1>Message ${message}</h1>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    User : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()"> Logout</a>
                </h2>
            </c:if>

        <sec:authorize access="hasRole('ROLE_USER')">
            <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm" >
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    User : ${pageContext.request.userPrincipal.name} | <a
                        href="javascript:formSubmit()"> Logout</a>
                </h2>
            </c:if>
        </sec:authorize>
    </body>
</html>
