<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%@ page isELIgnored="false" %>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%-- <% session.setAttribute("loggedin", false);%> --%>
<%-- <% if (request.getSession().getAttribute("loggedin")) {
     %> --%>
<% 
    try {
        if (session.getAttribute("loggedin").toString().equals("true")) {
            request.setAttribute("username", request.getSession().getAttribute("username"));
            request.setAttribute("link", "profile.jsp");
        } else {
            request.setAttribute("username", "Login");
            request.setAttribute("link", "login.jsp");
        }
    } catch(Exception ex) {
        request.setAttribute("loggedin", false);
        request.setAttribute("username", "Login");
        request.setAttribute("link", "login.jsp");
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
