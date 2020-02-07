<%@ page contentType='text/HTML' pageEncoding='UTF-8'%>
<%-- <%@ include file="template.jsp" %> --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
    try {
        if (session.getAttribute("loggedin").toString().equals("true")) {
            response.sendRedirect("profile.jsp");
             %>
            <script>console.out("Logged in")</script>
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
        <div class="container">
            <div class="form-header"><h2>Register</h2></div>
            <form action="register" method="POST" id="form">
                <div class="formField"><input type="text" name="user" placeholder="Username"></div><br>
                <div class="formField"><input type="password" name="pass" placeholder="Password"></div><br>
                <div class="formField"><input type="password" name="re-pass" placeholder="Retype Password"></div><br>
                <div class="formField"><input type="text" name="email" placeholder="Email"></div><br>
                <div class="formField"><input type="text" name="dob" placeholder="Date of Birth dd-mm-yyy"></div><br>
                <div class="formField"><input type="number" name="phnumber" placeholder="Phone Number"></div><br>
                <input id="login-button" type="submit" value="Register" />
            </form>
        </div>
    </jsp:body>
</t:template>