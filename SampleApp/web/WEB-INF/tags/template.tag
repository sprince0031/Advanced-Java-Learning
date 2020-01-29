<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" fragment="true" required="true"%>
<%@attribute name="footer" fragment="true" required="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sample App</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    
    <!-- CSS local files -->
    <link rel="stylesheet" href="css/main.css">
    
    <!-- Latest compiled and minified CSS (Bootstrap)-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
    <div id="pageHeader" class="navbar navbar-custom navbar-fixed-top menu-top" style="background: #fff;">

        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="index.jsp" class="navbar-brand">
                    <h1 style="margin-top: -8px; color: #000;">My Sample App</h1>
                    <!--<img src="#" alt="logo">-->
                </a>
            </div>
            <div class="navbar-collapse collapse">
                <nav>
                    <ul class="nav navbar-nav navbar-right" style="color:#000;">
                        <!-- <li><a class="page-scroll" href="#home" style="text-decoration:none !important;">Home</a></li>
                        <li><a class="page-scroll" href="#footer" style="text-decoration:none;">About</a></li>
                        <li><a class="page-scroll" href="#questions" style="text-decoration:none;">Questions of the week</a></li>
                        <li><a class="page-scroll" href="timeline.html" style="text-decoration:none;">Archived questions</a></li>
                        <li><a class="page-scroll" href="#leaderboard" style="text-decoration:none;">Leader Board</a></li>
                        <li><a class="page-scroll" href="compiler.html" target="_blank" style="text-decoration:none;"><i class="glyphicon glyphicon-menu-left"></i> Code_Playground / <i class="glyphicon glyphicon-menu-right"></i></a></li> -->
                        <c:choose>
                            <c:when test="${loggedIn == false}">
                                <li>
                                    <a class="page-scroll" href="login.jsp" style="text-decoration:none;">
                                        Login
                                    </a>
                                </li> 
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a class="page-scroll" href="profile.jsp" style="text-decoration:none;">
                                        Welcome ${user}!
                                    </a>
                                </li> 
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav><!--- END NAV -->
            </div> 
        </div><!--- END CONTAINER -->
        <!-- END NAVBAR -->
        <%-- <jsp:invoke fragment="header"/> --%>
    </div>

    <div id="body">
        <jsp:doBody/>
    </div>

    <!-- start footer -->
    <footer id="footer">
        <div class="container-fluid">
            <div class="row">
                <!-- <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    <a href="index.html">
                        <img src="logo.png" alt="The BeEm Initiative" height="50px" width="60px">
                    </a>
                </div> -->
                <%-- <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <p>
                    <img src="logo.png" alt="The BeEm Initiative" height="70px" width="80px" style="margin-right:10px; margin-top: -30px;">
                    </p>
                </div> --%>
                <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
                <div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                    <p>
                    Made with <i class="glyphicon glyphicon-heart" style="color:red;"></i> and lots of <span style="color:whitesmoke;"><i class="glyphicon glyphicon-menu-left"></i><span style="font-size: 18px; font-weight:bold;">/</span><i class="glyphicon glyphicon-menu-right"></i></span> by <a href="https://github.com/sprince0031">Sprince0031</a>.
                    </p>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
            </div>
        </div>
    </footer>
    <!-- end footer -->

</body>
</html>
