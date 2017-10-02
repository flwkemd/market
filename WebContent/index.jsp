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
              <a class="nav-link js-scroll-trigger" href="#store"  onclick="goStore();">상점소개</a>
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
            <h2 class="section-heading"><span class="text"><a href="market.jsp">시장 소개</a></span></h2>
            <h3 class="section-heading text-muted" align="right"><a href="market.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
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
          	<h2 class="section-heading"><span class="text"><a href="store.jsp">상점 소개</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="store.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
          </div>
        </div>
        <div class="row">
        
        <!-- 1 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal1">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/01-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>1번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal1"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
         
         <!-- 2 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal2">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/02-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>2번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal2"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
         
         <!-- 3 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal3">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/03-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>3번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal3"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
         <!-- 4 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal4">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/04-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>4번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal4"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
         <!-- 5 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal5">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/05-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>5번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal5"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
         <!-- 6 -->
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal6">
              <div class="store-hover">
                <div class="store-hover-content">
                  <i class="fa fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/06-thumbnail.jpg" alt="">
            </a>
            
            <div class="store-caption">
              <h4>6번 상점</h4>
              <p class="text-muted">내용</p>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">서울시 중랑구</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>주차공간</dt>
					<dd class="item_content">ㅇㅁㅇ</dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="#storeModal6"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
           		</div>
            </div>
          </div>
         
           		</div>
            </div>
    </section>

    <!-- Video -->
    <section id="video">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="video.jsp">행사 & 영상</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="video.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
          </div>
          <div class="col-md-12">
          	<img src="img/1.jpg">
      </div>
        </div>
        </div>
    </section>
    
        <!-- Search -->
    <section class="bg-light" id="search">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="search.jsp">재료 검색</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="search.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
            <hr>
            <!-- <h3 class="section-subheading text-muted">내용</h3> -->
          </div>
        </div>
          <div class="col-lg-12">
				<form role="search" method="get" class="left" action="#">
                        	<input type="hidden" name="post_type" value="course">
                        	<input type="search" name="s" id="s" placeholder="요리를 검색하세요.">
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
            <h2 class="section-heading"><span class="text"><a href="storeAddr.jsp">상점 위치</a></span></h2>
          	<h3 class="section-heading text-muted" align="right"><a href="storeAddr.jsp" class="click_a">더보기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
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
          <div class="col-lg-12 text-left">
            <a href="address.jsp"><h2 class="section-heading">오시는 길</h2></a>
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

    <!-- store Modals -->

    <!-- Modal 1 -->
    <div class="store-modal modal fade" id="storeModal1" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장1</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/01-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Modal 2 -->
    <div class="store-modal modal fade" id="storeModal2" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장2</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/02-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Modal 3 -->
    <div class="store-modal modal fade" id="storeModal3" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장3</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/03-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Modal 4 -->
    <div class="store-modal modal fade" id="storeModal4" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장4</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/04-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Modal 5 -->
    <div class="store-modal modal fade" id="storeModal5" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장5</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/05-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
 
    <!-- Modal 6 -->
    <div class="store-modal modal fade" id="storeModal6" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <!-- Project Details Go Here -->
                  <h2>시장6</h2>
                  <p class="item-intro text-muted">내용</p>
                  <img class="img-fluid d-block mx-auto" src="img/portfolio/06-full.jpg" alt="">
                  <p>내용</p>
                  <ul class="list-inline">
                    <li>위치: 서울시 중랑구 </li>
                    <li>운영시간: 00:00 ~ 24:00</li>
                  </ul>
                  <button class="btn btn-primary" data-dismiss="modal" type="button" id="modalbtn">
                    <i class="fa fa-times"></i>
                    닫기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>


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