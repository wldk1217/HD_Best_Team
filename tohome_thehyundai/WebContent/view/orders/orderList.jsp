<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<title>주문하기</title>
<link rel="stylesheet" type="text/css" href="view/orders/order.min.css">
<body>
	<div id="wrap" class="order ordersheet">
		<header id="header" class="short">
			<div class="inner">
				<!-- toparea// -->
				<div class="toparea">
					<h1>
						<a href="#"><img
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
		<!-- contents// -->
		<div id="contents">
			<div class="innercon" style="margin: 0 20% 0 25%;">
				<h2>주문하기</h2>
				<form>

					<div class="delivery-banner" id="divMultiDlvBtn">
						<p>주문해 주셔서 감사합니다</p>
					</div>

					<div class="conarea">
						<section class="leftarea">
							<div id="orderShippingSlitmDiv">
								<fieldset class="delivery-field toggle active"
									id="order_dstn_seq_0000000001" data-dstn_seq="0000000001">
									<legend class="tit toggle-ti"> 배송지 정보 </legend>
								</fieldset>


								<fieldset class="product-field toggle active">
									<legend class="tit toggle-ti">
										주문상품<em>0</em>
									</legend>
									<div class="cont">
										<a href="">여기에 상품리스트 뿌려주기</a>
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
													<dt>총 상품금액</dt>
													<dd>
														<em id="#">0</em>원
													</dd>
												</dl>
											</fieldset>
											<p class="txt">* 총 상품정보를 확인하세요.</p>
											<button type="button" class="btn fill orange">주문 하기</button>
										</div>
									</div>
								</div>

							</div>
</body>
</html>
