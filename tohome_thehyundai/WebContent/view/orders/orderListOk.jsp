<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="view/orders/order.min.css">
<title>OrderInsertOk</title>
</head>
<body>
	<div id="wrap" class="order ordersheet">
		<header id="header" class="short">
			<div class="inner">
				<div class="toparea">
					<h1>
						<a href="tohomeServlet?command=index"><img
							src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/temp/header_logo_freex34.png"
							alt="현대식품관"></a>
					</h1>

					<div class="util">
						<a href="#">로그아웃</a> <a href="#">회원정보변경</a> <a href="#">마이페이지</a>
						<a href="#">고객센터</a>
					</div>

				</div>
			</div>
		</header>

		<div id="contents" style="margin: 299px 20% 0px 0px;">
			<div class="innercon">
				<h2 class="hide">주문실패</h2>

				<div class="faildata">
					<h3 style="font-size:30px; text-align:center;">주문/결제가 완료되었습니다.</h3>
					<p style="font-size:20px; text-align:center;">더 많은 상품을 만나보세요!</p><br><br> 
					<div class="btns">
						<a href="tohomeServlet?command=index"
							class="btn fill big lightgray orange">메인으로가기</a> <a
							href="tohomeServlet?command=product_All" class="btn fill big orange">쇼핑계속하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>