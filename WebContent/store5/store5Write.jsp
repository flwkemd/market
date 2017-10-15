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
    
    <script language="javaScript" src="store5.js" ></script>
    
    

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
              <a class="nav-link js-scroll-trigger" href="../storeMain.jsp">상점소개</a>
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
	  
	<div class="container">
		<div class="row" id="frmWrite">
			<div class="write">
			<form method="post" action="Store5WriteAction.eo" name="board_frm" enctype="multipart/form-data">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3" style="background-color: #eeeeee; text-align: center;">음식점(상점5) 글쓰기 양식</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="3"><input type="text" class="form-control" placeholder="분류 ex. 음식점" name="store5Form" maxlength="20"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" class="form-control" placeholder="상점 이름 ex. 상점5" name="store5Title" maxlength="50"/></td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" class="form-control" placeholder="전화번호 ex. 02-3214-1242" name="store5Num" maxlength="50"/></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="영업시간(평일) ex. 10:00 ~ 21:00" name="store5Time1" maxlength="50"/></td>
					<td><input type="text" class="form-control" placeholder="영업시간(주말) ex. 10:00 ~ 21:00" name="store5Time2" maxlength="50"/></td>
					<td><input type="text" class="form-control" placeholder="영업시간(휴일) ex. 첫째주 일요일" name="store5Holiday" maxlength="50"/></td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="서비스(온누리상품권) ex. O" name="store5Service1" maxlength="50"/></td>
					<td><input type="text" class="form-control" placeholder="서비스(배달서비스) ex. O " name="store5Service2" maxlength="50"/></td>
					<td><input type="text" class="form-control" placeholder="서비스(카드결제) ex. X" name="store5Service3" maxlength="50"/></td>
				</tr>
				<tr>	
					<td colspan="3"><input type="file" class="form-control" name="store5File1"/></td>
				</tr>
				<tr>	
					<td colspan="3"><input type="file" class="form-control" name="store5File2"/></td>
				</tr>
			</tbody>
			</table>
				<input type="hidden" name="id" value="<%=id%>">
				<input type="button" class="btn btn-primary pull-right" id="frmBtn" onclick="boardConfirm()" value="글쓰기">
			</form>
			</div>
		</div>
	</div>

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
    
  </body>

</html>