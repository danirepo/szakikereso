<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="container">
        <div class="header">
            <div class="six columns">
                <a href="<c:url value="/index.htm" />"><img src="<c:url value="/images/logo.png"/>" alt="Szaki kereső" title="Szaki kereső" class="logo"/></a>
            </div>
            <div class="ten columns">
                <h2>Belépés</h2>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>

                    <form name='loginForm'
                          action="<c:url value='/j_spring_security_check' />" method='POST'>

                        <label>E-mail: </label><input type="text" name="email"/>
                        <label>Jelszó: </label><input type="password" name="password"/>
                        <input type="submit" value="Belépés" name="submit"/>

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
                    <p>Sikeresen bejelentkezett! | <a
                            href="javascript:formSubmit()"> Kijelenkezés</a></p>
                </c:if>
            </div>
        </div>
        <div class="clear"></div>
        <div class="menu sixteen columns">
            <ul>
                <li><a href="<c:url value="/index.htm" />">Kezdőoldal</a></li>
                <li><a href="<c:url value="/kereses.htm" />">Keresés</a></li>
                <li><a href="<c:url value="/regisztracio.htm" />">Regisztráció</a></li>
            </ul>
        </div>
        <div class="clear"></div>