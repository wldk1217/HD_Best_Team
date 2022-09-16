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
<link rel="stylesheet" href="view/footer.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />
<title>Document</title>
</head>

<body>
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

	<div class="contents">
		<div class="innercon">
			<section class="lnbarea">
				<h2>마이페이지</h2>
				<ul>
					<li class="lnb-depth1"><a href="#">주문관리</a>
						<ul class="lnb-depth2">
							<li><a href="tohomeServlet?command=order_list_all">주문 내역</a></li>
							<li><a href="/front/od/odd/orderCnclList.do"
								onclick="fn_GaEvent(this);">주문취소</a></li>
							<li><a href="/front/od/odd/orderExchRtpList.do"
								onclick="fn_GaEvent(this);">반품/교환</a></li>
							<li><a href="/front/od/odd/massOrdInqr.do"
								onclick="fn_GaEvent(this);">대량주문 문의</a></li>
							<li><a href="/front/od/odd/prmsSbScrptnList.do"
								onclick="fn_GaEvent(this);">투홈구독</a></li>
							<li><a href="/front/od/odd/rintrvDlvList.do"
								onclick="fn_GaEvent(this);">정기배송 설정</a></li>
						</ul></li>
					<li class="lnb-depth1"><a href="#">나의 정보</a>
						<ul class="lnb-depth2">
							<li><a href="/front/cua/mypage/certPwd.do"
								onclick="fn_GaEvent(this);">회원정보 변경</a></li>
							<li><a href="/front/od/odd/shippingList.do"
								onclick="fn_GaEvent(this);">배송지 관리</a></li>
							<!-- <li><a href="#">간편계정연결관리</a></li> -->
							<li><a href="/front/cua/mypage/loginHistList.do"
								onclick="fn_GaEvent(this);">로그인 기록</a></li>

							<li><a href="/front/od/odd/hpointPayMethodMng.do"
								onclick="fn_GaEvent(this);">H.Point Pay</a></li>

							<li><a href="/front/od/odd/stlmWayMng.do"
								onclick="fn_GaEvent(this);">Home Pay</a></li>
							<li><a href="/front/cua/mypage/personalInfoUseStatus.do"
								onclick="fn_GaEvent(this);">개인정보 이용현황</a></li>
							<li><a href="/front/cua/mypage/cashinfo.do"
								onclick="fn_GaEvent(this);">환불계좌/현금영수증</a></li>
							<li><a href="/front/cua/front/staffCertify.do"
								onclick="fn_GaEvent(this);">임직원 인증</a></li>
							<li><a href="/front/cua/mypage/custCarInfo.do"
								onclick="fn_GaEvent(this);">차량 등록</a></li>
						</ul></li>
				</ul>
			</section>
			<section class="conarea">
				<h3 class="tit">주문목록</h3>

				<div class="orderlist-area">

					<p>${orderList}</p>
					<c:forEach items="${orderList}" var="order">

						<ul class="order-list">
							<li class="order"><a href="tohomeServlet?command=order_list_detail&orderId=${order.orderId}"><strong class="order-date">${order.orderDate}</strong></a><br>
								<span class="order-info">${order.orderCount}
									${order.orderState} ${order.totalPrice}</span></li>
						</ul>
					</c:forEach>

					<c:if test="${orderList eq null}">
						<div class="nodata">주문내역이 없습니다.</div>
					</c:if>


					<div class="pagination"></div>
				</div>
			</section>
		</div>
	</div>

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
</html>
