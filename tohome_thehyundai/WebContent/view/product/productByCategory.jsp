<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/product/ProductPage.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<link href="./view/footer.css" rel="stylesheet" />
<title>ProductByCategory</title>
</head>

<body id="body">
	<!-- header -->
	<header class="header">
		<h1 class="logo">
			<a href="./index.html"> <img
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
							<li><a class="dropdown-item"
								href="tohomeServlet?command=product_by_category&categoryId=${CategoryVO.categoryId}">${CategoryVO.categoryType}</a></li>
						</c:forEach>
					</ul>
				</div>
			</li>
		</div>
		<li>전체상품</li>
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

	<div class="container">
		<c:forEach items="${productList}" var="ProductVO">
			<!-- 이미지 -->
			<div class="item-img-wrapper">
				<img
					src="${ProductVO.productImg}"
					alt="image">
			</div>

			<!-- 상품 제목 -->
			<div class="item-title">
				<p>${ProductVO.productName}</p>
			</div>

			<!-- 상품 가격 cart 아이콘 -->
			<div class="item-bottom">

				<div class="item-price">
					<p class="discount-per">10%</p>
					<span>${ProductVO.productName}원</span>
				</div>

				<a href=""><i class="bi bi-cart fs-4"></i></a>
			</div>		
		</c:forEach>
	</div>
</body>
</html>