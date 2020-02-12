<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="head" fragment="true" required="false"%>
<%@attribute name="header" fragment="true" required="false"%>
<%@attribute name="footer" fragment="true" required="false"%>
<%@attribute name="username" required="false" %>
<%@attribute name="link" required="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Just For Laughs</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    
    <!-- CSS local files -->
    <link rel="stylesheet" href="css/main.css">
    
    <!-- Latest compiled and minified CSS (Bootstrap)-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- jQuery import -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/4baab900e5.js" crossorigin="anonymous"></script>

    <jsp:invoke fragment="head"/>
</head>
<body>
    <header id="pageHeader" class="navbar navbar-custom navbar-fixed-top menu-top" style="background: #fff;">

        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="index.jsp" class="navbar-brand">
                    <h1>Just For Laughs</h1>
                    <!--<img src="#" alt="logo">-->
                </a>
            </div>
            <div class="navbar-collapse collapse">
                <nav>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a id="login-button" class="page-scroll" href="${link}" style="text-decoration:none;">${username}</a></li>
                        <c:if test="${loggedin}">
                            <li>
                                <form action="logout" method="POST">
                                    <button id="logout-button"><i class="glyphicon glyphicon-off"></i></button>
                                </form>
                            </li>
                        </c:if>
                        <jsp:invoke fragment="header"/>
                    </ul>
                </nav><!--- END NAV -->
            </div> 
        </div><!--- END CONTAINER -->
        <!-- END NAVBAR -->
        
    </header>

    <%-- <div id="body"> --%>
    <jsp:doBody/>
    <%-- </div> --%>

    <!-- start footer -->
    <footer id="footer" class="fixed-bottom container-fluid">
        <div class="row">
            <jsp:invoke fragment="footer"/>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <p>
                Made with <i class="fas fa-heart" style="color:red;"></i> and lots of <i class="fas fa-code" style="color:whitesmoke;"></i> by <a href="https://github.com/sprince0031">Sprince0031</a>.
                </p>
            </div>
        </div>
    </footer>
    <!-- end footer -->

</body>
</html>
