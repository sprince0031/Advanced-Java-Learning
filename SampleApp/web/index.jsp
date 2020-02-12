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
        <script src="js/jokegen.js"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="joke-container">
            <!-- <div class="road">
                <div class="road-shadow"></div>
            </div> -->
            <div id="jokeGenerator">
                <div class="printJoke">
                    <div id="setup">Welcome to random fun!</div><br>
                    <div id="punchline">Please login if you want to ensure no jokes are repeated.</div>
                </div><br>
                <button id="btn" type="submit" onclick="jokeGen()">Get Random Joke!</button>
                <div class="row" id="btn-actions">
                    <div id="fav-btn" onclick="favouriteAction()" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <i class="far fa-heart"></i>
                    </div>
                    <div id="share-btns" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <i class="fab fa-twitter"></i>
                    </div>
                </div>
            </div>

        </div>
    </jsp:body>
</t:template>
