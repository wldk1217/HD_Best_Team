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
<title>basketList</title>
<link rel="stylesheet" href="view/orders/basketList.css" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet" type="text/css" href="view/orders/order.min.css">
</head>
<header id="header" class="short">
	<div class="inner">
		<!-- toparea// -->
		<div class="toparea">
			<h1>
				<a href="tohomeServlet?command=index"><img
					src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/temp/header_logo_freex34.png"
					alt="현대식품관"></a>
			</h1>

			<div class="util">
				<a href="tohomeServlet?command=logout">로그아웃</a><a
					href="tohomeServlet?command=mypage">마이페이지</a> <a
					href="tohomeServlet?command=inquiry_list">고객센터</a>
			</div>

		</div>
	</div>
</header>
<body>
	<div class="contents">
		<div class="innercon">
			<div class="test">
				<h2>장바구니</h2>
			</div>
			<div class="shipping">
				<p>
					주문 <em>${basketCount}</em>
				</p>
			</div>

			<c:forEach items="${basketList}" var="BasketVO" varStatus="status">
				<div class="productList">
					<input type="hidden" name="productId" value="${BasketVO.productId}" />
					<input type="hidden" name="basketId" value="${BasketVO.basketId}" />
					<input id="price" type="hidden" name="productPrice"
						value="${BasketVO.productPrice}" />

					<div class="basket_img"
						onclick="location.href='tohomeServlet?command=product_detail&productId=${BasketVO.productId}';">
						<img src="${BasketVO.productImg}" alt="image" />
					</div>

					<div class="prod_ctn">
						<div class="txt_ellipsis">
							<p id="txt-ellipsis-p">${BasketVO.productName}</p>
							<button class="btn_delete"
								onclick="location.href='tohomeServlet?command=basket_delete&productId=${BasketVO.productId}&basketId=${BasketVO.basketId}'">
								<i class="bi bi-x"></i>
							</button>
						</div>
						<div class="info">
							<div class="ea-area">
								<form
									action="tohomeServlet?command=basket_update&productId=${BasketVO.productId}&basketId=${BasketVO.basketId}"
									method="post">
									<input type="text" name="count"
										value="${BasketVO.basketQuantity}" id="ea-area-input" />
									<button type="submit" id="ea-area-btn" class="btn fill orange">수량변경</button>
								</form>
								<p id="total" style="font-size: 20px;">
									<span style="font-weight: bold; color: gray;">1개&nbsp/&nbsp</span>${BasketVO.productPrice}&nbsp원</p>
							</div>
						</div>
					</div>
				</div>
				<div class="btn_order">
					<form
						action="tohomeServlet?command=order_insert&basketOrder=1&productId=${BasketVO.productId}&productPrice=${BasketVO.productPrice}"
						method="post">
						<input type="hidden" name="count"
							value="${BasketVO.basketQuantity}" id="ea-area-input" />
							
						<c:if test="${lastSize eq status.index}">
						<button type="submit" id="btn_order-btn" class="btn fill orange">주문
							하기</button>
						</c:if>
					</form>
				</div>
			</c:forEach>


		</div>
	</div>
</body>
</html>
