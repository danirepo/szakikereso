<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container">
        <div id="header">
            <div class="clearfix">
                <div class="logo">
                    <a href="<c:url value="/index.htm" />"><img src="<c:url value="/images/megegylogo.png"/>" alt="LOGO" height="80" width="240"></a>
                </div>
                <div class="login">
                    <a href="<c:url value="/regisztracio.htm" />"><h1>Regisztráció</h1> </a>
                    <!--<a href="<c:url value="/login.htm" />"><h1>Belépés</h1> </a>-->
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <c:if test="${not empty error}">
                            <div class="error">${error}</div>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </c:if>

                        <form name='loginForm'
                              action="<c:url value='/j_spring_security_check' />" method='POST'>

                            <table>
                                <tr>
                                    <td>user:</td>
                                    <td><input type='text' name='email'></td>
                                </tr>
                                <tr>
                                    <td>Password:</td>
                                    <td><input type='password' name='password' /></td>
                                </tr>
                                <tr>
                                    <td colspan='2'><input name="submit" type="submit"
                                                           value="submit" /></td>
                                </tr>
                            </table>

                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />

                        </form>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <c:url value="/j_spring_security_logout" var="logoutUrl" />
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />
                        </form>
                        <script>
                            function formSubmit() {
                                document.getElementById("logoutForm").submit();
                            }
                        </script>
                        <h2>Ön már bejelentkezett! ${pageContext.request.userPrincipal.name}| <a
                                href="javascript:formSubmit()"> Logout</a></h2>
                    </c:if>
                </div>
                <ul class="navigation">
                    <li class="active">
                        <a href="<c:url value="/index.htm" />">Főoldal</a>
                    </li>
                    <li>
                        <a href="<c:url value="/kereses.htm" />">Keresés</a>
                    </li>
                    <li>
                        <a href="contact.html">Szakemberek</a>
                    </li>
                    <li>
                        <a href="<c:url value="/regisztracio.htm" />">Regisztráció</a>
                    </li>
                </ul>
            </div>
        </div>