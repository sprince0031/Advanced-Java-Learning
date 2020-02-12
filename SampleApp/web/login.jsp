<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    try {
        if (session.getAttribute("loggedin").toString().equals("true")) {
            response.sendRedirect("profile.jsp");
             %>
            <script>console.log("Logged in")</script>
<%     
        }

    } catch(Exception ex) { 
        session.setAttribute("username", "Login");

    }
%>

<t:template username="${username}" link="${link}">
    <jsp:attribute name="head">
        <%-- individual css --%>
        <link rel="stylesheet" href="css/form.css">
    </jsp:attribute>
    <jsp:body>
        <br><br><br>
        <div id="form-div" class="container">
            <div class="form-header"><h2>Login</h2></div>
            <form action="login" method="POST" id="form">
                <div class="formField"><input type="text" name="user" placeholder="Username"></div><br>
                <div class="formField"><input type="password" name="pass" placeholder="Password"></div><br>
                <input id="login-button" type="submit" value="Login" />
            </form>
            <div id="register-link">
                <a href="register.jsp">Don't have an account? Register now!</a>
            </div>
        </div>
    </jsp:body>
</t:template>