<%@page import="jsp.market.model.MarketBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.market.model.MarketDAO"%>
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
    
	<script src="market.js"></script>    
    

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
              <a class="nav-link js-scroll-trigger active" href="#market">시장 소개</a>
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
              <a class="nav-link js-scroll-trigger" href="../address/address.jsp">오시는 길</a>
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
	  
    <!-- Market -->
    <section id="market">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <a href="#"><h2 class="section-heading">시장 소개</h2></a>
            <%
            	if(id!=null){
            %>
            <h3 class="section-heading text-muted" align="right"><a href="marketWrite.jsp" class="click_a">글쓰기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
          	<%
            	}
          	%>
            <hr>
            <h3 class="section-subheading text-muted">시장 소개 글</h3>
          </div>
        </div>
       <div class="row text-center">
        
        
        <%
        	MarketDAO dao = new MarketDAO();
			ArrayList<MarketBean> list = dao.getBoardList();
			for(int i=0; i<list.size(); i++){
        %>
          <div class="col-md-4">
            <a href="#"><img src="../UploadFolder/Market/<%= list.get(i).getmFile() %>"></a>
            <h4 class="service-heading"><%= list.get(i).getmTitle() %></h4>
            <p class="text-muted"><%= list.get(i).getmContent() %></p>
             	<hr>
          </div>
        <%
			}
        %>
     
         </div>
         
         
          <div class="col-lg-12">
			<button type="button" class="btn btn-default" id="call_btn" onclick="callbtn();"><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>연락처
		       <div class="popup">
				  <span class="popuptext" id="myPopup">02-1234-1232</span>
			   </div>
			</button>
		  </div>
          <div class="col-lg-12">
			<button type="button" class="btn btn-default" id="addr_btn" onclick="location.href='http://map.naver.com/?lng=65c5b338a33ec4f8f857c1e86d0f60fc&title=%EB%A9%B4%EB%AA%A9%EC%8B%9C%EC%9E%A5&pinId=18190673&lat=ef943ec8023f246e841a1296664c68eb&dlevel=9&mLevel=9&enc=b64&pinType=site&y=ef943ec8023f246e841a1296664c68eb&x=65c5b338a33ec4f8f857c1e86d0f60fc'"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>오시는 길</button>
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