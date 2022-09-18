<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<title>주문하기</title>
<link rel="stylesheet" type="text/css"
	href="view/mypage/orderListDetail.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous">
    </script>
</head>
<body>
	<!-- header.jsp 삽입 -->
	<jsp:include page="/header.jsp"/>
	<!-- contents// -->
	<div id="contents">

		<div class="innercon">
			<h2>주문 내역 상세보기</h2>

	
			<fieldset class="list-field toggle active">
			<h3>주문 번호 : ${orderId}</h3>
				<div class="cont" style="display: block;">
					<ul class="product-list vertical">
						<c:forEach items="${orderDetail}" var = "order">
							<li dlvdivision="1_DAWN" data-dlvc_pay_gbcd="10"><label
								class="thumb"> <span><img
										src="${order.product.productImg}"
										alt="${order.product.productName}"></span>

							</label>
								<div class="contr">
								<div class="productdetail_sub1">
									<strong class="txt-ti ellipsis">${order.product.productName}</strong>
									</div>
									<div class="productdetail_sub2" style="padding:30px">
										<strong><em>${order.product.productPrice}</em>원</strong> <strong><em>${order.orderQuantity}</em>개</strong>
										
									</div>
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</fieldset>

		</div>

	</div>
	
	<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>


</body>
</html>
