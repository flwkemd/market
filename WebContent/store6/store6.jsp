<%@page import="jsp.store6.model.Store6Bean"%>
<%@page import="jsp.store6.model.Store6DAO"%>
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
    <link href="../makeStore/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="../makeStore/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="../makeStore/css/agency.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="../makeStore/css/custom.css" rel="stylesheet">
    
    

  </head>

  <body id="page-top">

	<%
		String id = null;
		if (session.getAttribute("id") != null){
			id = (String) session.getAttribute("id");
		}
		
		int start =1;
		if(request.getAttribute("start") != null){
			start = (Integer)request.getAttribute("start");
		}
		
		int startPage =1;
		if(request.getAttribute("startPage") !=null){
			startPage = (Integer)request.getAttribute("startPage");
		}
		int endPage =1;
		if(request.getAttribute("endPage") !=null){
			endPage = (Integer)request.getAttribute("endPage");
		}
		int spage =1;
		if(request.getAttribute("spage") !=null){
			spage = (Integer)request.getAttribute("spage");
		}
		int maxPage =1;
		if(request.getAttribute("maxPage") !=null){
			maxPage = (Integer)request.getAttribute("maxPage");
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
              <a class="nav-link js-scroll-trigger" href="../makeStore/storeMain.jsp">상점소개</a>
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
          	<p class="sub-title text-center">의류/신발 상점별 안내</p>
          	<p class="sub-font1 text-center">면목시장은 찾아오시는 고객분들을 위한<br>다양한 편의시설이 준비되어 있습니다.</p>
          	<%
            	if(id!=null){
            %>
            <h3 class="section-heading text-muted" align="right"><a href="store6/store6Write.jsp" class="click_a">글쓰기<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a></h3>
          	<%
            	}
          	%>
            <hr>
          </div>
        </div>
        
		<div class="table-board">
			<table class="table" id="store-tbl">
			<colgroup>
                <col width="15%">
                <col width="29%">
                <col width="56%">
                <col width="10%">
                </colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>구분</th>
						<th>상점명</th>
						<th>상점정보</th>
					</tr>
				</thead>
				<tbody>
				
				<%
					Store6DAO store6DAO = new Store6DAO();
	        		ArrayList<Store6Bean> list = store6DAO.getBoardList(start);
	        		for(int i=0; i<list.size(); i++){
				%>
				
				<tr align="center">
					<td><%= list.get(i).getStore6Id() %></td>
					<td><%= list.get(i).getStore6Form() %></td>
					<td><%= list.get(i).getStore6Title()%></td>
					<td><a href="store6Detail.do?store6Id=<%= list.get(i).getStore6Id() %>" class="view">상세보기</a></td>
				</tr>
				
				<%
	        		}
				%>
				
				</tbody>
				</table>
  			 </div>
  		 </div>
  		 
  		 	<div id="pageForm">
				<%
					if(startPage != 1){
				%>	
					<a href='store6.do?page=<%=startPage %>' id="numBtn">[이전]</a>	
				<%
					}
					for(int i=startPage; i<=endPage; i++){
						if(i == spage){
				%>
						<a id="numBtn"><%= i %>&nbsp;</a>
				<%		
						}else{
				%>
						<a href="store6.do?page=<%= i %>" id="numBtn"><%= i %>&nbsp;</a>
				<%			
						}
					}
				%>
				
				<%
					if(endPage != maxPage){
				%>
					<a href='store6.do?page=<%=endPage %>' id="numBtn">[다음]</a>	
				<%		
					}
				%>
			</div>	
   	</div>
				
   	<br>
   	
   	
   	
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