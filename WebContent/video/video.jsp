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
              <a class="nav-link js-scroll-trigger" href="#video">행사&영상</a>
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

    <!-- Video -->
    <section id="video">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-left">
            <h2 class="section-heading"><span class="text"><a href="#">행사 & 영상</a></span></h2>
            <%
            	if(id!=null){
            %>
          	<%
            	}
          	%>
            <hr>
          </div>
                          <div class="row">

                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm" action="course_view.jsp">
                            <a href="#" onclick="data();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/wozQbgJdZoI">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/wozQbgJdZoI/0.jpg" alt=""></a>
                            <div class="card-block">
                                <a href="#"><p class="card-text">자기 계발 시작 가이드</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm1" action="course_view.jsp">
                            <a href="#" onclick="data1();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/m6P66ppnnqw">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/m6P66ppnnqw/0.jpg" alt=""></a>
                            <div class="card-block">
                                <a href="#"><p class="card-text">나는 왜 내편이 아닌가?</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm2" action="course_view.jsp">
                            <a href="#" onclick="data2();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/YoHv_4AVB_4">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/YoHv_4AVB_4/0.jpg" alt=""></a>
                            <div class="card-block">
                                <a href="#"><p class="card-text">습관을 바꾸는 방법</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm3" action="course_view.jsp">
                            <a href="#" onclick="data3();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/xybrVYunO8w">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/xybrVYunO8w/0.jpg" alt=""></a>
                            <div class="card-block">
                                <a href="#"><p class="card-text">당신은 열정적이지 않다.</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm4" action="course_view.jsp">
                            <a href="#" onclick="data4();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/wPU_P6I3ASg">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/wPU_P6I3ASg/0.jpg" alt=""></a>
                            <div class="card-block">
                                <a href="#"><p class="card-text">결정적인 순간에 해내는 방법</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                        <form name="frm5" action="course_view.jsp">
                            <a href="#" onclick="data5();">
                            <input type="hidden" name="data" value="https://www.youtube.com/embed/1L3T9UcFxiA">
                            <img class="card-img-top img-fluid" src="https://i.ytimg.com/vi/1L3T9UcFxiA/0.jpg" alt=""></a>
                            <div class="card-block">
                               <a href="#"><p class="card-text">자기 계발 5대 키워드</p></a>
                            </div>
                        	</form>
                            <div class="card-footer" align="right">
                                <small class="text-muted">조회수 12회</small>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- /.row -->
          
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