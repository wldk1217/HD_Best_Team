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
<link rel="stylesheet" href="view/product/productDetail.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<script type="text/javascript" src="productDetail.js"></script>
<title>prodcutDetail</title>
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
			<a href="">로그인</a> <a href="">회원가입</a> <a href="">마이페이지</a> <a
				href="">고객센터</a>
		</div>
	</header>
	<!-- 상품 상세 페이지 -->
	<div class="contents">
		<div id="content_first">
			<div class="productInfo">
				<div id="productImg"><img src="${productVO.productImg}" alt="image"></div>
			</div>
			<div class="productInfo">
				<div class="productName">
					<h2>${productVO.productName}</h2>
				</div>
				<div class="productSimpleInfo">${shortDetail}
				</div>
				<br>
				<div class="productPrice">
					<div class="priceItem">
						<h3>${productVO.productPrice}</h3>
					</div>
					<div class="priceItem">원</div>
				</div>
				<br>
				<br>
				<hr>
				<div class="productOrigin">
					<div class="originItem">원산지</div>
					<div class="originItem">${productVO.productOrigin}</div>
				</div>
				<br>
				<div class="productOrigin2">
					<div class="originItem">상품선택</div>
					<div class="originItem">
						<div class="proName">${productVO.productName}</div>
						<br>
						<div>
							<button class="btn btn-secondary">-</button>
							<input type="text" class="productCount">
							<button class="btn btn-secondary">+</button>
						</div>
					</div>
				</div>
				<br>
				<div class="productTotal">
					<div class="proTotal">총 금액</div>
					&nbsp&nbsp
					<div class="proTotal">
						<h3>????????</h3>
					</div>
					<div class="proTotal">원</div>
				</div>
				<br> <br> <br> <br>
				<div class="btns">
					<button type="button" class="btn orange bigger">장바구니</button>
					<button type="button" class="btn orange bigger"
						style="background: #FFAA40;">바로구매</button>
				</div>
			</div>
		</div>
		<br>
		<br>
		<hr>
		<br>
		<br>
		<div class="content_second">
			<div class="tabmenu out-tabmenu">
				<ul>
					<li id="tab1" class="btnCon"><input type="radio" checked
						name="tabmenu" id="tabmenu1"> <label for="tabmenu1">상세정보</label><br>
						<div class="tabCon">
							<div><img src="${productVO.productImg}" alt="image"></div>
							<div>${productVO.productDetail}</div>
						</div></li>
					<li id="tab2" class="btnCon"><input type="radio"
						name="tabmenu" id="tabmenu2"> <label for="tabmenu2">취소/교환/반품</label>
						<div class="tabCon">
							<div>
								<h2>주문취소 안내</h2>
								- 결제완료 이후 주문의 상태가 "상품 준비중" 으로 변경될 경우, 취소가 제한됩니다. <br> <br>
								<br>
								<h2>교환/반품 안내</h2>

								- 상품에 문제가 있는 경우, 냉장/냉동은 2일 내, 상온제품은 일주일 이내에 가능합니다.<br> -
								단순변심/주문착오 경우, 최대 7일 이내 사진과 함께 1:1문읙 게시판에 등록하시면, 담당자 확인 후 진행됩니다.<br>
								- 교환/반품이 불가한 경우, 기간을 초과하였을 경우 또는 상품이 훼손된 경우, 배송 후 설치가 완료된 경우
								불가합니다.
							</div>
						</div></li>
					<li id="tab3" class="btnCon"><input type="radio"
						name="tabmenu" id="tabmenu3"> <label for="tabmenu3">1:1
							문의</label>
						<div class="tabCon">
							<div class="tabmenu3_wrap">
								<h2>문의관련 안내</h2>
								- 문의 답변은 1~3일까지 소요될 수 있습니다.<br>
								<br>
								<br>
								<h2>고객센터 운영 시간</h2>
								- 월-금 10:00~17:00 <br> - 주말, 공휴일은 휴무입니다.<br>
								<br>
								<h3>02-1234-1234</h3>
								<br>
								<br>
								<button type="button" class="btn orange bigger">1:1문의
									바로가기</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>