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
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="../css/agency.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="../css/custom.css" rel="stylesheet">
    
    

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
        <a class="navbar-brand js-scroll-trigger" href="../index.jsp">면목시장</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger active" href="../market/market.jsp">시장 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../store/store.jsp">상점소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../video/video.jsp">행사&영상</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../search/search.jsp">재료 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../storeAddr/storeAddr.jsp">상점위치</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#address">오시는 길</a>
            </li>
            <%
            	if(id == null){
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../login.jsp">로그인</a>
            </li>
            <%
            	}else{
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="../logout.jsp">로그아웃</a>
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

        <!-- address -->
    <section class="bg-light" id="address">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <a href="#"><h2 class="section-heading">오시는 길</h2></a>
            <hr>
        	<div class='embed-container'><iframe src='https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1070.5298010586564!2d127.08722714906635!3d37.57926124709852!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357cbae379e08479%3A0x4ebe8c477b7e9b8!2z66m066qp7Iuc7J6l!5e0!3m2!1sko!2skr!4v1506881643025' width='1000' height='450' frameborder='0' style='border:0' allowfullscreen></iframe></div>
          </div>
        </div>
        
        <div class="map_adr _mapButtonArea">
        <div class="col-lg-12 col-xs-12">
          <h3 id="name">면목시장</h3>
          <p id="addr" class="theme_color">서울특별시 중랑구 면목동 650</p>
          <div class="map_ico_btn_wrap" id="btn_wrap" align="right">
          	 <button type="button" class="btn btn-default btn-lg btn-block" id="findload"><span class="glyphicon glyphicon-sort" aria-hidden="true"></span>길찾기</button>
          	 <button type="button" class="btn btn-default btn-lg btn-block" id="seemap"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>지도에서 보기</button>
          	</div>
          </div>
        </div>
        
        	<hr>
        	
		<div class="local_area">
	      <dl class="list_info">
	        <dt class="item_title"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> 오시는길</dt>
	        <dd class="item_description">
	          <span class="text">오시는길 추가안내하는부분</span>
	          <span class="text"><span class="sub_title">주차정보</span><span class="sub_text">주차정보내용</span></span>
	        </dd>
	      </dl>
	      <hr>
	      <dl class="list_info">
	        <dt class="item_title"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 전화번호</dt>
	        <dd class="item_description">
	          <span class="text">1234</span>
	          <span class="text">1234</span>
	        </dd>
	      </dl>
	      <hr>
	      
	      <dl class="list_info">
	        <dt class="item_title"><span class="glyphicon glyphicon-time" aria-hidden="true"></span> 이용시간</dt>
	        <dd class="item_description">
	          <span class="text">
				<span class="sub_title">매일</span>	
				<span class="sub_text"> 00:00 - 24:00</span>
			  </span>
	          <span class="text sub_description">시간예시 + 설명부분</span>
	        </dd>
	      </dl>
			</div>          



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
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/popper/popper.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="../js/jqBootstrapValidation.js"></script>
    <script src="../js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="../js/agency.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script src="../js/custom.js"></script>
    
    
    

  </body>

</html>