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
    <jsp:attribute name="head">
        <link rel="stylesheet" href="css/animation.css">
    </jsp:attribute>
    <jsp:body>
        <div class="animation-container">
            <div class="road">
                <div class="road-shadow"></div>
            </div>
        </div>
    </jsp:body>
</t:template>
