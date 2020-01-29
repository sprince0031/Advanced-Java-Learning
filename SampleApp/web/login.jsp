<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <jsp:attribute name="header"></jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>
    <jsp:body>
        <br><br><br>
        <div class="container">
            <form action="login" method="POST" id="loginForm">
                Username: <input type="text" name="user"><br>
                Password: <input type="text" name="pass"><br>
                <input type="submit">
            </form>
        </div>
    </jsp:body>
</t:template>