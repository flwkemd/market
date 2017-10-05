<%@page import="jsp.search.model.SearchBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.search.model.SearchDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>            
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
		int pageNumber = 1;
		if(request.getParameter("pageNumber") != null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		String word = null;
	%>

 <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-white fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="index.jsp">면목시장</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="market.jsp">시장 소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger active" href="store.jsp">상점소개</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="video.jsp">행사&영상</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger active" href="#search">재료 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="storeAddr.jsp">상점위치</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="address.jsp">오시는 길</a>
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

     <header class="masthead">
	  	<div class="container">
        	<div class="intro-text">
        	</div>
      	</div>
	  </header>

        <!-- Search -->
    <section class="bg-light" id="search">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="search.jsp">재료 검색</a></span></h2>
            <%
            	if(id!=null){
            %>
            <h3 class="section-heading text-muted" align="right"><a href="search/searchWrite.jsp" class="click_a">글쓰기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
          	<%
            	}
          	%>
            <hr>
          </div>
        </div>
          <div class="col-lg-12">
				<form role="search" method="get" class="left" action="SearchSearchAction.so">
                        	<input type="search" name="word" id="word" placeholder="요리를 검색하세요.">
                        	<input type="submit" class="searchsubmit" value="검색">
                </form>
                        <hr class="intro-divider"> 
      	  </div>
      
       <div class="row">
            
        <c:forEach var="board" items="${requestScope.list}">
          <div class="col-md-4 col-sm-6 store-item">
            <a class="store-link" data-toggle="modal" href="#storeModal1">
              <div class="store-hover">
                <div class="store-hover-content">
                </div>
              </div>
              <img class="img-fluid" src="UploadFolder/Search/${board.sFile }" >
            </a>
            
            <div class="store-caption">
              <h4>${board.sTitle }</h4>
              <hr>
            <div class="info">
				<dl class="infolist">
					<dt class="item_title">
						<span class="glyphicon glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<span class="text">주소</span>
					</dt>
						<dd class="item_content"> <span class="text">${board.sAddress }</span></dd>
				</dl>
				<hr>
				<dl class="infolist">
					<dt class="item_title">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>이용시간</dt>
					<dd class="item_content">${board.sTime1 } : ${board.sTime2 } ~ ${board.sTime3 } : ${board.sTime4 } </dd>
				</dl>
				<hr>
					<a class="store-link" data-toggle="modal" href="SearchDetailAction.so?sId=${board.sId }"><button class="btn btn-default btn-lg btn-block">바로가기</button></a>
					<hr>
           		</div>
            </div>
          </div>

      </c:forEach>
      </div>

sId:<c:out value="${board.sId }"></c:out>

<c:forEach var="board" items="${requestScope.board}">
sid:${board.sId }
</c:forEach>

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
    
    <!-- Modal 1 -->
	<c:forEach var="board" items="${requestScope.board}">
    <div class="store-modal modal fade" tabindex="-1" role="dialog" aria-hidden="true">
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
                  <h2>${board.sTitle }</h2>
                  <img class="img-fluid d-block mx-auto" src="UploadFolder/Search/${board.sFile }">
                  <ul class="list-inline">
                    <li>위치: ${board.sAddress }</li>
                    <li>운영시간: ${board.sTime1 }:${board.sTime2 } ~ ${board.sTime3 }:${board.sTime4 }</li>
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
    </c:forEach>
    
    

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