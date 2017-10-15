<%@page import="jsp.store.model.StoreBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.store.model.StoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>면목시장</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/custom.css" rel="stylesheet">
    
    

  </head>

  <body id="page-top">
  
  	<%
		String id = null;
		if (session.getAttribute("id") != null){
			id = (String) session.getAttribute("id");
		}
	%>
  

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-white fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="../makeStore/index.jsp">면목시장</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger active" href="../makeStore/market/market.jsp">시장 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#">상점소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/video/video.jsp">행사&영상</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/search/search.jsp">재료 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/storeAddr/storeAddr.jsp">상점위치</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/address/address.jsp">오시는 길</a>
            </li>
            <%
            	if(id == null){
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/login.jsp">로그인</a>
            </li>
            <%
            	}else{
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../makeStore/logout.jsp">로그아웃</a>
            </li>
            <%
            	}
            %>
            
          </ul>
        </div>
      </div>
    </nav>

     <header class="masthead">
	  	<div class="container">
        	<div class="intro-text">
        	</div>
      	</div>
	  </header>

    <!-- Store -->
    <section class="bg-light" id="store">
    <div class="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
          	<p class="sub-title text-center">면목시장 상점별 안내</p>
          	<p class="sub-font1 text-center">면목시장은 찾아오시는 고객분들을 위한<br>다양한 편의시설이 준비되어 있습니다.</p>
            <hr>
            <p id="sub-font2">면목시장 상점 목록</p>
          </div>
        </div>
        
        <div class="row">
        
        <!-- 1 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store1.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/1.jpg" alt="">
            </a>
           </div>
           
        <!-- 2 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store2.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/2.jpg" alt="">
            </a>
           </div>
           
        <!-- 3 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store3.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/3.jpg" alt="">
            </a>
           </div>
           
        <!-- 4 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store4.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/4.jpg" alt="">
            </a>
           </div>
           
        <!-- 5 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store5.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/5.jpg" alt="">
            </a>
           </div>
           
        <!-- 6 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store6.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/6.jpg" alt="">
            </a>
           </div>
         
        <!-- 7 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store7.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/7.jpg" alt="">
            </a>
           </div>
         
        <!-- 8 -->
          <div class="col-xs-6 col-md-3 store-item">
            <a class="store-link" href="store8.do">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/store/8.jpg" alt="">
            </a>
           </div>
         
         
         
           		</div>
           		<hr>
					<p id="sub-font2">위치 보기</p>
					<img src="img/storeAddr.jpg">
            </div>
    </section>
   
   <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <span class="copyright">Copyright &copy; Your Website 2017</span>
          </div>
          <div class="col-md-6">
            <ul class="list-inline quicklinks">
              <li class="list-inline-item">
                면목시장
              </li>
              <li class="list-inline-item">
                02-2132-1241
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
    
    <!-- Bootstrap core JavaScript -->
    <script src="../makeStore/vendor/jquery/jquery.min.js"></script>
    <script src="../makeStore/vendor/popper/popper.min.js"></script>
    <script src="../makeStore/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../makeStore/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="../makeStore/js/jqBootstrapValidation.js"></script>
    <script src="../makeStore/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="../makeStore/js/agency.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script src="../makeStore/js/custom.js"></script>
    

  </body>

</html>