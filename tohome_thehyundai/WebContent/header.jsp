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
<link href="./header.css" rel="stylesheet" />
<title>Here is header</title>
</head>
<body>
	<!-- header -->
	<header class="header">
		<h1 class="logo">
			<a href="./index.html"> <img
				src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/common/header_logo_freex34.png"
				alt="logo" />
			</a>
		</h1>

		<div class="util">
			<c:if test="${memberId ne null}">
				<a>${memberId}님 환영합니다!</a>
				<a href="tohomeServlet?command=mypage">마이페이지</a>
				<a href="tohomeServlet?command=logout">로그아웃</a>
				<a href="tohomeServlet?command=inquiry_list">고객센터</a>
			</c:if>
			<c:if test="${memberId eq null}">
				<a href="tohomeServlet?command=login_form">로그인</a>
				<a href="tohomeServlet?command=join_form">회원가입</a>
				<a href="tohomeServlet?command=inquiry_list">고객센터</a>
			</c:if>
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
								href="tohomeServlet?command=product_by_category&categoryId=${CategoryVO.categoryId}">${CategoryVO.categoryType}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</li>
		</div>
		<li><a href="tohomeServlet?command=product_All"
			style="color: #41464b">전체상품</a></li>
		<li><a href="tohomeServlet?command=product_sale"
			style="color: #41464b">세일</a></li>
		<li><a href="tohomeServlet?command=prouduct_new"
			style="color: #41464b">신상품</a></li>
		<li><a href="#" style="color: #41464b">매거진</a></li>
		<li><a href="#" style="color: #41464b">선물하기</a></li>
		<li><a href="#" style="color: #41464b">이벤트</a></li>
		<div class="search">
			<input type="text" />
			<div class="search-icon">
				<i class="bi bi-search"></i>
			</div>
		</div>

		<div class="cart" onClick="location.href='tohomeServlet?command=basket_list'">
			<i class="bi bi-cart fs-4"></i>
			<div class="count">
				<p>${basketCount}</p>
			</div>
		</div>
	</ul>
</body>
</html>