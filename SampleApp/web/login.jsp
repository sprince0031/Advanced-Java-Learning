<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template username="${username}" link="${link}">
    <jsp:attribute name="head">
        <%-- individual css --%>
        <link rel="stylesheet" href="css/login.css">
    </jsp:attribute>
    <jsp:body>
        <br><br><br>
        <div class="container">
            <form action="login" method="POST" id="loginForm">
                <div class="formField">Username: <input type="text" name="user"></div><br>
                <div class="formField">Password: <input type="password" name="pass"></div><br>
                <input id="login-button" type="submit" value="Login" />
            </form>
        </div>
    </jsp:body>
</t:template>