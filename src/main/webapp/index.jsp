
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
   String uploadUrl = blobstoreService.createUploadUrl("/image-analysis"); %>

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>Log in</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="29722303600-tdknl0tf235cf63neugl8ldhpembt861.apps.googleusercontent.com">
<meta name="google-signin-client_id" content="29722303600-ol12qti3qf649fkcmdfj7ljr94dme2pe.apps.googleusercontent.com">
<meta name="google-signin-client_id" content="29722303600-gqo8prq7odsoj2ch6dhotatjgstos5uu.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>

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
<style  type="text/css">
  footer{
    padding-top: 250px;
  }
  body{
    background-image: url(https://previews.123rf.com/images/romastudio/romastudio1603/romastudio160300280/54088843-healthy-food-background-studio-photo-of-different-fruits-on-white-wooden-table-high-resolution-produ.jpg);
  }

  .center {
    margin: auto;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
    margin-top: 200px;
  }
</style>

<!-- reCAPTCHA Libary -->
<script src='https://www.google.com/recaptcha/api.js?hl=en'></script>

</head>
  <body>
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
                            <ul class="nav navbar-nav navbar-right" id="navigation">
                                <li class="active">
                                    <a class="page-scroll" href="/index.html">Home</a>
                                </li>
<!--                                 <li>
                                    <a class="page-scroll" href="/recipes.html">Recipes</a>
                                </li> -->
                                <li><a href="/map.html">Locations</a></li>
<!--                                 <li>
                                    <a class="page-scroll" href="#services" onclick="openSearch()">Search</a>
                                </li> -->
                                <li>
                                    <a class="page-scroll" href="/aboutus.html">About Us</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/translation.html">Translation</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/index.jsp">Image Analysis</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/feed.html">All Recipes</a>
                                </li>
                                <li>
                                    <a class="page-scroll" href="/community.html">Community</a>
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

    <div class="center">
    <h2>Image Upload Analysis</h2>
    <form method="POST" enctype="multipart/form-data" action="<%= uploadUrl %>">
      <p>Upload an image:</p>
      <input type="file" name="image">
      <br/><br/>
      <button>Submit</button>
    </form>
  </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>