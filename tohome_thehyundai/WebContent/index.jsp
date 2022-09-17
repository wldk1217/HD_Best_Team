<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

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
<title>index</title>
</head>

<body id="body">
	<!-- header.jsp 삽입 -->
	<jsp:include page="/header.jsp"/>
	
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
					<strong>[중앙해장] 곱창전골</strong>
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
	
	<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
	
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