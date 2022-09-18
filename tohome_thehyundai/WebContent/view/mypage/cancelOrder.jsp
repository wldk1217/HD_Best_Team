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
<link rel="stylesheet" href="view/mypage/orderList.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous">
    </script>
<title>Document</title>
</head>

<body>
	<!-- header.jsp 삽입 -->
	<jsp:include page="/header.jsp"/>
	
	<div class="contents">
		<div class="innercon">
			<!-- nav -->
			<jsp:include page="nav.jsp"/>
			
			
			
			<section class="conarea">
				<h3 class="tit">주문 취소</h3>
				${catagoryList}
				<div class="orderlist-area">

					<c:forEach items="${orderList}" var="order">
						<c:if test="${order.orderState eq '주문취소'}">
							<ul class="order-list">
								<li class="order"><div class="txt_ellipsis">
										<strong class="delivery_log" style="width:10px; background-color:Orange;">취소</strong>
										<a
											href="tohomeServlet?command=order_list_detail&orderId=${order.orderId}"><strong
											class="order-date">${order.orderDate}</strong></a>
									</div>
									<div class="txt_ellipsis">
										<span class="order-info">
											<span>주문 번호 : ${order.orderCount} </span>
											<span>${order.orderState}</span>
											<span>${order.totalPrice}</span>
											<span>주문번호 : ${order.orderId}</span></span></span>
									</div></li>
								
							</ul>
						</c:if>
					</c:forEach>

					<c:if test="${orderList eq null}">
						<div class="nodata">취소내역이 없습니다.</div>
					</c:if>


					<div class="pagination"></div>
				</div>
			</section>
		</div>
	</div>

	<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
</body>
</html>
