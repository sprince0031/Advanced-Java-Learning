<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%-- <% 
    if (session.getAttribute("loggedin").toString().equals("true")) {
        request.setAttribute("username", request.getSession().getAttribute("username"));
        request.setAttribute("link", "profile.jsp");
    } else {
        request.setAttribute("username", "Login");
        request.setAttribute("link", "login.jsp");
    }
%> --%>
<t:template username="${username}" link="${link}">
    <jsp:body>
        <br><br><br>
        <div class="container">
            <form action="login" method="POST" id="loginForm">
                Username: <input type="text" name="user"><br>
                Password: <input type="password" name="pass"><br>
                <input type="submit" value="Login">
            </form>
        </div>
    </jsp:body>
</t:template>