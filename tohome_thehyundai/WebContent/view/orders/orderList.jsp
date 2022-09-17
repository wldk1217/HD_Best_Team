<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<script>
	function insert_order() {
		if (document.formm.paymentType.value == 1) {
			alert("결제 수단을 선택하여 주세요.");
		} else {
			document.formm.action = "tohomeServlet?command=order_insert_ok";
			document.formm.submit();
		}
	};
</script>
<head>
<title>주문하기</title>
<link rel="stylesheet" type="text/css" href="view/orders/order.min.css">
</head>
<body>
	<div id="wrap" class="order ordersheet">
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
						<a href="tohomeServlet?command=logout">로그아웃</a><a href="tohomeServlet?command=mypage">마이페이지</a>
						<a href="tohomeServlet?command=inquiry_list">고객센터</a>
					</div>

				</div>
			</div>
		</header>
		<!-- contents// -->
		<div id="contents">
			<div class="innercon" style="margin: 0 20% 0 25%;">
				<h2>주문하기</h2>
				<form method="post" name="formm">
					<input type="hidden" name="totalPrice" value="${ordersVO.totalPrice}"/>
					<div class="delivery-banner" id="divMultiDlvBtn">
						<p>주문해 주셔서 감사합니다</p>
					</div>

					<div class="conarea">
						<section class="leftarea">
							<div id="orderShippingSlitmDiv">
								<fieldset class="delivery-field toggle active"
									id="order_dstn_seq_0000000001" data-dstn_seq="0000000001">
									<legend class="tit toggle-ti"> 배송지 정보 </legend>
									<h3>${memberVO.memberName}</h3>
									<h3>${memberVO.memberTel}</h3>
									<h3>${memberVO.memberAdderss}</h3>
									&nbsp&nbsp&nbsp
								</fieldset>
								<fieldset class="product-field toggle active">
									<legend class="tit toggle-ti">
										주문상품<em>1</em>
									</legend>
									<div class="cont" style="font-size: 20px;">
										<p>[${productVO.productName}]</p>
										<p style="margin-right: 40px;">${ordersVO.orderCount}&nbsp개</p>
										<p style="margin-right: 40px;">${ordersVO.totalPrice}&nbsp원</p>
									</div>
								</fieldset>
								<div id="p_popCouponChoiceHTML" class="popup popcouponchoice">
									<div class="inner">
										<header>
											<h2>상품 주문 하기</h2>
										</header>
										<div class="contents">

											<fieldset class="coupon-field">
												<dl class="orderprice">
													<dt style="font-size: 20px;">총 상품금액</dt>
													<dd>
														<em id="#" style="font-size: 30px;">${ordersVO.totalPrice}</em>원
													</dd>
													<dt>
														결제 방법&nbsp&nbsp <select id="paymentType"
															name="paymentType">
															<option value=1 selected>-선택하세요-</option>
															<option value="신용카드">신용카드</option>
															<option value="무통장 입금">무통장 입금</option>
															<option value="계좌이체">계좌이체</option>
														</select>
													</dt>
												</dl>
											</fieldset>
											<p class="txt">* 총 상품정보를 확인하세요.</p>
											<button type="button" class="btn fill orange"
												onclick="insert_order()">주문 하기</button>
										</div>
									</div>
								</div>

							</div>
						</section>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
