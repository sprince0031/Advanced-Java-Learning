<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<% 
    try {
        if (session.getAttribute("loggedin").toString().equals("true")) {
            session.setAttribute("username", session.getAttribute("username"));
            session.setAttribute("link", "profile.jsp");
        } else {
            session.setAttribute("username", "Login");
            session.setAttribute("link", "login.jsp");
        }
    } catch(Exception ex) {
        session.setAttribute("loggedin", false);
        session.setAttribute("username", "Login");
        session.setAttribute("link", "login.jsp");
    }
%>
<t:template username="${username}" link="${link}">
    <jsp:body>
        <div class="jumbotron">
            <br><br><br>
            <h1>Ahoy there! This is a test</h1>
        </div>
    </jsp:body>
</t:template>
