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
    <jsp:attribute name="head">
        <%-- individual css --%>
        <link rel="stylesheet" href="css/profile.css">
        <script src="js/jokegen.js"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="dashboard">
            <div class="div1">
                <h1>Welcome to your dashboard ${username}!</h1>
                <div class="fav-list">
                    <ul id="fav-list">
                        <li></li>
                    </ul>
                </div>
            </div>
        </div>
        <script>
            window.onload = function() {
                listFavs();
            };
        </script>
    </jsp:body>
</t:template>