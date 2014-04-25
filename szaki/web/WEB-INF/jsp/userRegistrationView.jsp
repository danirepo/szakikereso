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
        <script type="text/javascript" src="<c:url value="/resource/check.js" />"></script>
        <script type="text/javascript" src="<c:url value="/web/WEB-INF/js/jquery-1.11.0.min.js"/>"></script>
        <style>
            .error {
                color: #ff0000;
            }

            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body>
        <spring:nestedPath path="userRegistration">
            <form:form commandName="userRegistration" method="POST">
                <form:errors path="*" cssClass="errorBlock" element="div" />
                Vezetéknév:
                <spring:bind path="lastName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Vezetéknév" />
                </spring:bind>
                Keresztnév:
                <spring:bind path="firstName">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="Keresznév" />
                    <form:errors path="firstName" cssClass="error" />
                </spring:bind>
                E-mail:
                <spring:bind path="email">
                    <input type="text" name="${status.expression}" value="${status.value}" placeholder="E-mail" />
                </spring:bind>
                Jelszó:
                <spring:bind path="password">
                    <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" />
                </spring:bind>
                Jelszó megerősitése:
                <spring:bind path="password2">
                    <input type="password" name="${status.expression}" value="${status.value}" placeholder="Jelszó" />
                </spring:bind>
                <input type="submit" value="Regisztráció" />
            </form:form>
        </spring:nestedPath>
    </body>
</html>
