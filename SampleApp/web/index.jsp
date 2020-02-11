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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="animation-container">
            <!-- <div class="road">
                <div class="road-shadow"></div>
            </div> -->
            <div id="jokeGenerator">
                <div class="printJoke">
                    <div id="setup"></div><br>
                    <div id="punchline"></div>
                </div><br>
                <button id="btn" type="submit" onclick="jokeGen()">Get Random Joke!</button>
            </div>

            <script>
                async function getRandJoke() {
                    var requestOptions = {
                        method: 'GET',
                        redirect: 'follow',
                        mode: 'cors'
                    };

                    const response = await fetch('https://official-joke-api.appspot.com/random_joke', requestOptions);
                    return await response.json();
                }

                function jokeGen() {
                    getRandJoke().then((jsondata) => {
                        console.log(jsondata);
                        $.ajax({
                            type: "GET",
                            url: "joke",
                            data: "id="+jsondata.id,
                            success: function(data) {
                                if (data === "true") {
                                    console.log("Already cracked this joke.. :P")
                                    jokeGen();
                                } else {
                                    document.getElementById("setup").innerHTML = jsondata.setup;
                                    document.getElementById("punchline").innerHTML = jsondata.punchline;
                                }
                            }
                        });
                    });
                }
            </script>
        </div>
    </jsp:body>
</t:template>
