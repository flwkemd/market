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
        <a class="navbar-brand js-scroll-trigger" href="#page-top">면목시장</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#market" onclick="goMarket();">시장 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#store" onclick="goStore();">상점소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#video"  onclick="goVideo();">행사&영상</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#search"  onclick="goSearch();">재료 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#storeAddr"  onclick="goStoreAddr();">상점위치</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#address"  onclick="goAddress();">오시는 길</a>
            </li>
            <%
            	if(id == null){
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="login.jsp">로그인</a>
            </li>
            <%
            	}else{
            %>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="logout.jsp">로그아웃</a>
            </li>
            <%
            	}
            %>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
   <header class="masthead">
      <div class="container">
        <div class="intro-text">
        </div>
      </div>
    </header>


<!-- Market -->
<section id="market">
	  <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="market/market.jsp">시장 소개</a></span></h2>
            <h3 class="section-heading text-muted" align="right"><a href="market/market.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
          </div>
            <hr>
           
          </div>
        </div>

  <div class="container">
    	<div class="row">
        	<div class="col-md-12">
        <!-- Image Carousel -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid w-100" src="img/1.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">1번 사진</h3>
                <h2 class="text-shadow">첫번째 슬라이드 사진 입니다.</h2>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/2.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">2번 사진</h3>
                <h2 class="text-shadow">2번째 사진입니다.</h2>
              </div>
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid w-100" src="img/3.jpg" alt="">
              <div class="carousel-caption d-none d-md-block">
                <h3 class="text-shadow">3번 사진</h3>
                <h2 class="text-shadow">3번째 슬라이드 입니다.</h2>
              </div>
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>

           <h3 class="section-subheading text-muted">시장 소개 글</h3>
      </div>
      </div>
      </section>


    <!-- Store -->
    <section class="bg-light" id="store">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
          	<h2 class="section-heading"><span class="text"><a href="storeMain.jsp">상점 소개</a></span></h2>
            <hr>
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
            </div>
    </section>

    <!-- Video -->
    <section id="video">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="video/video.jsp">행사 & 영상</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="video/video.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
          </div>
          <div class="row">
          <div class="col-lg-6 col-md-6">
              <video src="img/video/1.mp4" controls preload="auto" height="285px;"></video>
          </div>
          <div class="col-lg-6 col-md-6">
              <video src="img/video/2.mp4" controls preload="auto" height="285px;"></video>
          </div>
        </div>
        </div>
    </section>
    
        <!-- Search -->
    <section class="bg-light" id="search">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="search/search.jsp">재료 검색</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="search/search.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
            <!-- <h3 class="section-subheading text-muted">내용</h3> -->
          </div>
        </div>
          <div class="col-lg-12">
				<form role="search" method="post" class="left" action="search/SearchSearchAction.so">
                        	<input type="search" name="word" id="word" placeholder="요리를 검색하세요.">
                        	<input type="submit" class="searchsubmit" value="검색">
                </form>
                        <hr class="intro-divider"> 
                        <h3 class="section-subheading text-muted">내용</h3> 
      	  </div>
          
    </section>
    
        <!-- storeAddr -->
    <section id="storeAddr">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="storeAddr/storeAddr.jsp">상점 위치</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="storeAddr/storeAddr.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
          </div>
        </div>
          <div class="col-md-12">
          	<img src="img/storeAddr.jpg">
      </div>
    </section>
    
        <!-- address -->
    <section class="bg-light" id="address">
      <div class="container">
        <div class="row">
            <a href="address/address.jsp"><h2 class="section-heading">오시는 길</h2></a>
         </div>
         <div class="row">   
          <div class="col-lg-6 text-left">
            <hr>
            	<!-- <iframe src='http://map.naver.com/?searchCoord=7ff053a342fadea52b085af2d77286f92812c806653b138f17483c6a5c228c49&query=66m066qp7Iuc7J6l&menu=location&tab=1&lng=c4ad2628ddfa0b1801f51e277a93c5af&mapMode=0&mpx=09260570%3A37.5796286%2C127.0863361%3AZ12%3A0.0174272%2C0.0056535&rpanel=n-f&lat=9c80de4a43f040953c435f4417530506&dlevel=12&enc=b64' width='1000' height='450' frameborder='0' style='border:0' allowfullscreen></iframe> -->
				<table cellpadding="0" cellspacing="0" width="462"> <tr> <td style="border:1px solid #cecece;"><a href="http://map.naver.com/?searchCoord=7ff053a342fadea52b085af2d77286f92812c806653b138f17483c6a5c228c49&query=66m066qp7Iuc7J6l&tab=1&lng=c4ad2628ddfa0b1801f51e277a93c5af&mapMode=0&mpx=09260570%3A37.5796286%2C127.0863361%3AZ12%3A0.0174272%2C0.0056535&lat=9c80de4a43f040953c435f4417530506&dlevel=12&enc=b64&menu=location&rpanel=n-f" target="_blank"><img src="http://prt.map.naver.com/mashupmap/print?key=p1508027656481_-1142290021" width="460" height="340" alt="지도 크게 보기" title="지도 크게 보기" border="0" style="vertical-align:top;"/></a></td> </tr> <tr> <td> <table cellpadding="0" cellspacing="0" width="100%"> <tr> <td height="30" bgcolor="#f9f9f9" align="left" style="padding-left:9px; border-left:1px solid #cecece; border-bottom:1px solid #cecece;"> <span style="font-family: tahoma; font-size: 11px; color:#666;">2017.10.15</span>&nbsp;<span style="font-size: 11px; color:#e5e5e5;">|</span>&nbsp;<a style="font-family: dotum,sans-serif; font-size: 11px; color:#666; text-decoration: none; letter-spacing: -1px;" href="http://map.naver.com/?searchCoord=7ff053a342fadea52b085af2d77286f92812c806653b138f17483c6a5c228c49&query=66m066qp7Iuc7J6l&tab=1&lng=c4ad2628ddfa0b1801f51e277a93c5af&mapMode=0&mpx=09260570%3A37.5796286%2C127.0863361%3AZ12%3A0.0174272%2C0.0056535&lat=9c80de4a43f040953c435f4417530506&dlevel=12&enc=b64&menu=location&rpanel=n-f" target="_blank">지도 크게 보기</a> </td> <td width="98" bgcolor="#f9f9f9" align="right" style="text-align:right; padding-right:9px; border-right:1px solid #cecece; border-bottom:1px solid #cecece;"> <span style="float:right;"><span style="font-size:9px; font-family:Verdana, sans-serif; color:#444;">&copy;&nbsp;</span>&nbsp;<a style="font-family:tahoma; font-size:9px; font-weight:bold; color:#2db400; text-decoration:none;" href="http://www.nhncorp.com" target="_blank">NAVER Corp.</a></span> </td> </tr> </table> </td> </tr> </table>
          </div>
        <div class="col-lg-6 col-xs-12" position="relative";>
        	<hr>
	          <h3 id="name">면목시장</h3>
	          <p id="addr" class="theme_color">서울특별시 중랑구 면목동 650</p>
	          <p id="addr" class="theme_color">서울특별시 중랑구 면목로39길 11 카멜리아쇼핑센타</p>
	          	 <div class="map_ico_btn_wrap" id="btn_wrap">
	          	 	<button type="button" class="btn btn-default btn-lg btn-block" id="findload" onclick="location.href='http://map.naver.com/?elng=65c5b338a33ec4f8f857c1e86d0f60fc&dtPathType=0&menu=route&elat=ef943ec8023f246e841a1296664c68eb&mapMode=0&pathType=1&eText=%EB%A9%B4%EB%AA%A9%EC%8B%9C%EC%9E%A5'"><span class="glyphicon glyphicon-sort" aria-hidden="true"></span>길찾기</button>
	          	 	<button type="button" class="btn btn-default btn-lg btn-block" id="seemap" onclick="location.href='http://map.naver.com/?lng=65c5b338a33ec4f8f857c1e86d0f60fc&title=%EB%A9%B4%EB%AA%A9%EC%8B%9C%EC%9E%A5&pinId=18190673&lat=ef943ec8023f246e841a1296664c68eb&dlevel=9&mLevel=9&enc=b64&pinType=site&y=ef943ec8023f246e841a1296664c68eb&x=65c5b338a33ec4f8f857c1e86d0f60fc'"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>지도에서 보기</button>
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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/agency.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script src="js/custom.js"></script>
    

  </body>

</html>