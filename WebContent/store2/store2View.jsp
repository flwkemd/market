<%@page import="jsp.store2.model.Store2Bean"%>
<%@page import="jsp.store2.model.Store2DAO"%>
<%@page import="java.util.ArrayList"%>
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
		
		int store2Id =1;
		if(request.getParameter("store2Id") !=null){
			store2Id = Integer.parseInt(request.getParameter("store2Id"));
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
              <a class="nav-link js-scroll-trigger" href="storeMain.jsp">상점소개</a>
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

    <!-- Store -->
    <section class="bg-light" id="store">
    <div class="content">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
          	<p class="sub-title text-center">축산물 상점별 안내</p>
          	<p class="sub-font1 text-center">면목시장은 찾아오시는 고객분들을 위한<br>다양한 편의시설이 준비되어 있습니다.</p>
          	<%
            	if(id!=null){
            %>
            <h3 class="section-heading text-muted" align="right"><a href="store2/store2Write.jsp" class="click_a">글쓰기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
          	<%
            	}
          	%>
            <hr>
          </div>
        </div>
        
			 <%
				Store2DAO store2DAO = new Store2DAO();
			 	
      			Store2Bean store = store2DAO.getDetail(store2Id);
      	     %>
        
			<div class="col-lg-12 store-item">
              <img class="img-fluid" src="../UploadFolder/Store2/<%= store.getStore2File1() %>">
            
            <div class="store-caption">
              <h1><%= store.getStore2Title()%></h1>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
						<span class="text">전화번호</span>
					</dt>
						<dd class="item_content"> <span class="text">&nbsp;&nbsp;<%= store.getStore2Num() %></span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-time" aria-hidden="true"></span>영업시간</dt>
						<dd class="item_content"> <span class="text">평일 : </span><%=store.getStore2Time1() %></dd>
						<dd class="item_content"> <span class="text">주말 : </span><%=store.getStore2Time2() %></dd>
						<dd class="item_content"> <span class="text">휴일 : </span><%=store.getStore2Holiday() %></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>서비스</dt>
						<dd class="item_content"> <span class="text">온누리상품권 : </span><%=store.getStore2Service1() %></dd>
						<dd class="item_content"> <span class="text">배달서비스 : </span><%=store.getStore2Service2() %></dd>
						<dd class="item_content"> <span class="text">카드결제 : </span><%=store.getStore2Service3() %></dd>
				</dl>
				<hr>
				
				<p id="mapText"> 지도에서 위치 보기</p>
					<div class="col-lg-12">
						 <img class="img-fluid" src="../UploadFolder/Store2/<%= store.getStore2File2() %>">
					</div>
	             	  </div>
           		   </div>
    	       </div>
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