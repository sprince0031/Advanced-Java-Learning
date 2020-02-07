<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    try {
        if (session.getAttribute("loggedin").toString().equals("true")) {
             %>
            <script>console.out("Logged in")</script>
<%     
        } else {
             %>
            <script>alert("Login first!")</script>
<%     
            session.setAttribute("username", "Login");
            response.sendRedirect("login.jsp");
        }
   
    } catch(Exception ex) {
                %>
            <script>alert("Login first!")</script>
<%     
        session.setAttribute("username", "Login");
        response.sendRedirect("login.jsp");
    }
%>
<t:template username="${username}" link="${link}">
    <jsp:body>
        <div class="jumbotron">
            <br><br><br>
            <h1>Ahoy there ${username}! This is a test</h1>
        </div>
    </jsp:body>
</t:template>