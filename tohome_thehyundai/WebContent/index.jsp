<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./mainPage.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />

<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<link href="./view/footer.css" rel="stylesheet" />
<title>Document</title>
</head>

<body id="body">
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
		<div class="category">
			<li>
				<div class="dropdown">
					<button class="btn dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">
						<i class="bi bi-list"> 카테고리 전체보기 </i>
					</button>
					<ul class="dropdown-menu">
						<c:forEach items="${categoryList}" var="CategoryVO">
							<li><a class="dropdown-item" href="#">${CategoryVO.categoryType}</a></li>
						</c:forEach>
					</ul>
				</div>
			</li>
		</div>

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

	<!-- 슬라이드 -->
	<section id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img
					src="https://www.samyangfoods.com/upload/banner/20190618/20190618144917232036.jpg"
					class="d-block w-100" alt="image" />
			</div>
			<div class="carousel-item">
				<img
					src="https://www.samyangfoods.com/upload/banner/20211007/20211007151048228047.jpg"
					class="d-block w-100" alt="image" />
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</section>

	<!-- 타임세일 -->
	<section class="timesale">
		<!-- 알뜰 장보기 -->
		<div class="inner">
			<i class="bi bi-exclamation-lg" style="font-size: 8.5rem"></i>
			<h2>알뜰 장보기</h2>
			<p>지금 이 순간 만날 수 있는 특가</p>
		</div>

		<!-- 세일하는 음식 -->

		<div class="time-inner">
			<div class="time-cart">
				<i class="bi bi-cart fs-1"></i>
			</div>
			<div class="thumb">
				<div class="sale-percent">
					<p class="percent">15%</p>
				</div>
				<img
					src="https://tohomeimage.thehyundai.com/PD/PDImages/S/0/4/3/2801001047340_00.jpg?RS=720x864"
					alt="food-image" />
				<div class="txt">
					<strong>[중앙해장] 곱창전골 (중/2인분)</strong>
					<p class="price">55,000원</p>
				</div>
			</div>
		</div>
	</section>

	<!-- exhibition -->
	<ul class="exhibition" data-aos="fade-up">
		<li><a href="/"> <img
				src="https://tohomeimage.thehyundai.com/DP/DP034/2022/08/22/115648/dkxea.png?RS=1204x160"
				alt="image" />
		</a></li>
		<li><a href="/"> <img
				src="https://tohomeimage.thehyundai.com/DP/DP034/2021/11/01/104726/lqgpp.jpg?RS=1204x160"
				alt="image" />
		</a></li>
		<li><a href="/"> <img
				src="https://tohomeimage.thehyundai.com/DP/DP034/2022/08/22/115648/elqth.jpg?RS=1204x160"
				alt="image" />
		</a></li>
	</ul>

	<footer id="footer">
		<div class="util">
			<div class="inner">
				<a href="">브랜드소개</a> <a href="">이용약관</a> <a href="">개인정보처리방침</a> <a
					href="">청소년보호정책</a> <a href="">영상기기운영방침</a> <a href="#body">
					<button type="button" class="top_btn">
						<i class="bi bi-arrow-up-short"></i>TOP
					</button>
				</a>
			</div>
		</div>
	</footer>
</body>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
  AOS.init();
</script>
</html>