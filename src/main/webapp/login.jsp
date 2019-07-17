<%--
  Created by IntelliJ IDEA.
  User: danni
  Date: 7/15/19
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,400i,600,700|Raleway:300,400,400i,500,500i,700,800,900"
          rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="lib/nivo-slider/css/nivo-slider.css" rel="stylesheet">
    <link href="lib/owlcarousel/owl.carousel.css" rel="stylesheet">
    <link href="lib/owlcarousel/owl.transitions.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/venobox/venobox.css" rel="stylesheet">

    <!-- Nivo Slider Theme -->
    <link href="css/nivo-slider-theme.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Responsive Stylesheet File -->
    <link href="css/responsive.css" rel="stylesheet">
    <style>
        .pos {
            padding-top: 350px;
            margin: auto;
            width: 50%;
        }

        footer{
            padding-top: 250px;
        }

    </style>

</head>
<body>
<header>
    <!-- header-area start -->
    <div id="sticker" class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12">

                    <!-- Navigation -->
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target=".bs-example-navbar-collapse-1" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <!-- Brand -->
                            <a class="navbar-brand page-scroll sticky-logo" href="index.html">
                                <h1><span>Recipe</span>club</h1>
                                <!-- Uncomment below if you prefer to use an image logo -->
                                <!-- <img src="img/logo.png" alt="" title=""> -->
                            </a>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse main-menu bs-example-navbar-collapse-1"
                             id="navbar-example">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="active">
                                    <a class="page-scroll" href="/index.html">Home</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/recipes.html">Recipes</a>
                                </li>
                                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                        data-toggle="dropdown">User<span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="/login.jsp">Log in</a></li>
                                        <li><a href="/register.jsp">Register</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="page-scroll" href="#services" onclick="openSearch()">Search</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/aboutus.html">About Us</a>
                                </li>
                            </ul>
                        </div>
                        <!-- navbar-collapse -->
                    </nav>
                    <!-- END: Navigation -->
                </div>
            </div>
        </div>
    </div>
    <!-- header-area end -->
</header>
<!-- header end -->

<div class="pos">

    <h1>Log in</h1>
    <p style="color:red;font-weight: 900;font-size: 30px">${msg}</p>
    <form action="<c:url value='../java/com/recipe/servlet/LoginServlet'/> " method="post">
        <h4>User name</h4><input type="text" name="username" style="font-size: 20px" value="${user.username}"/>${errors.username}<br/>
        <h4>Password:</h4><input type="password" name="password" style="font-size: 20px" value="${user.password}"/>${errors.password}<br/>

        <input type="submit" value="Submit" style="font-size: 18px"><br/>
    </form>

</div>

<!-- Start Footer bottom Area -->
<footer>
    <div class="footer-area">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="footer-content">
                        <div class="footer-head">
                            <div class="footer-logo">
                                <h2><span>recipe</span>Club</h2>
                            </div>

                            <p>Best recipe platform.</p>
                            <div class="footer-icons">
                                <ul>
                                    <li>
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-google"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-pinterest"></i></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end single footer -->
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="footer-content">
                        <div class="footer-head">
                            <h4>information</h4>
                            <p>
                                Best platform. User-collaborative.
                            </p>
                            <div class="footer-contacts">
                                <p><span>Tel:</span> +123 456 789</p>
                                <p><span>Email:</span> contact@recipeclub.com</p>
                                <p><span>Working Hours:</span> 9am-5pm</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end single footer -->
                <div class="col-md-4 col-sm-4 col-xs-12">
                    <div class="footer-content">
                        <div class="footer-head">
                            <h4>Instagram</h4>
                            <div class="flicker-img">
                                <a href="#"><img src="img/portfolio/1.jpg" alt=""></a>
                                <a href="#"><img src="img/portfolio/2.jpg" alt=""></a>
                                <a href="#"><img src="img/portfolio/3.jpg" alt=""></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-area-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="copyright text-center">
                        <p>
                            &copy; Copyright <strong>recipe Club</strong>. All Rights Reserved
                        </p>
                    </div>
                    <div class="credits">
                        <!--
                          All the links in the footer should remain intact.
                          You can delete the links only if you purchased the pro version.
                          Licensing information: https://bootstrapmade.com/license/
                          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=eBusiness
                        -->
                        Powered by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/venobox/venobox.min.js"></script>
<script src="lib/knob/jquery.knob.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/parallax/parallax.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/nivo-slider/js/jquery.nivo.slider.js" type="text/javascript"></script>
<script src="lib/appear/jquery.appear.js"></script>
<script src="lib/isotope/isotope.pkgd.min.js"></script>

<!-- Contact Form JavaScript File -->
<script src="contactform/contactform.js"></script>

<script src="js/main.js"></script>
</body>
</html>
