<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/mypage/mypage.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous">
    </script>	
<title>Document</title>
</head>
<head>
<meta charset="UTF-8">
<title>mypage nav</title>
</head>
<body>
<section class="lnbarea">
				<h2>마이페이지</h2>
				<ul>
					<li class="lnb-depth1"><a href="#">주문관리</a>
						<ul class="lnb-depth2">
							<li><a href="tohomeServlet?command=order_list_all">주문 내역</a></li>
							<li><a href="tohomeServlet?command=order_list_cancel">주문취소</a></li>
							<li><a href="#" >반품/교환</a></li>
							
						</ul></li>
					<li class="lnb-depth1"><a href="#">나의 정보</a>
						<ul class="lnb-depth2">
							<li><a href="tohomeServlet?command=mypage">회원정보 변경</a></li>
							<li><a href="#">배송지 관리</a></li>
							
						</ul></li>
				</ul>
			</section>
</body>
</html>