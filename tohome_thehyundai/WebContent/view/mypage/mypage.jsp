<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./mypage.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<title>Document</title>
</head>
<body>
	<!-- header -->
	<header class="header">
		<h1 class="logo">
			<a href="/mainPage.html"> <img
				src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/common/header_logo_freex34.png"
				alt="logo" />
			</a>
		</h1>

		<div class="util">
			<a href="">로그인</a> <a href="">회원가입</a> <a href="">마이페이지</a> <a
				href="">고객센터</a>
		</div>
	</header>

	<!-- global navigation bar  -->
	<ul class="gnb-list">
		<div>
			<i class="bi bi-list">카테고리 전체보기</i>
		</div>
		<li>베스트</li>
		<li>세일</li>
		<li>신상품</li>
		<li>매거진</li>
		<li>선물하기</li>
		<li>이벤트</li>
		<div class="search">
			<input type="text" />
			<div class="search-icon">
				<i class="bi bi-search"></i>
			</div>
		</div>

		<div class="cart">
			<i class="bi bi-cart fs-4"></i>
			<div class="count">
				<p>1</p>
			</div>
		</div>
	</ul>

</body>

</html>