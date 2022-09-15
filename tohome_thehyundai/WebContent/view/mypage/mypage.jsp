<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/mypage/mypage.css" />
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
				<h3 class="tit">회원정보 변경</h3>
				<form id="mainform" method="post"
					action="tohomeServlet?command=password_check">
					<fieldset class="form-field">
						<legend class="hide">비밀번호 입력</legend>

						<p class="txt">
							<strong>비밀번호를 입력해주세요.</strong> 고객님의 개인정보 보호를 위해 비밀번호를 다시 확인합니다.<br />
							비밀번호가 타인에게 노출되지 않도록 항상 주의해 주세요.
						</p>

						<label class="form-entry inline"> <input type="password"
							id="PWD" name="PWD" title="비밀번호 확인 입력" placeholder="비밀번호"
							onkeydown="" />
							<button type="button" class="btn-del" tabindex="-1">삭제</button> <!--
                        메세지 띄우기 : fn.inputMsg('input ID명', '에러 메세지'); / fn.inputMsg('input ID명', '긍정 메세지', true);
                        특정 메세지 지우기 : fn.inputMsgClear('input ID명');
                        전체 메세지 지우기 : fn.inputMsgClear();
                    -->
							<button type="submit" class="btn fill black">확인</button>
						</label>
						<!-- <div class="infotxt">
                    <ul>
                        <li>영문, 숫자, 특수문자를 포함하여 8~30자 이내 사용 가능</li>
                    </ul>
                </div> -->
					</fieldset>
				</form>
			</section>
		</div>
	</div>
	<script>
		function certPwd() {
			fn.inputMsgClear("#PWD");
			if ($("#PWD").val() == null || $("#PWD").val() == "") {
				fn.inputMsg("#PWD", "비밀번호를 입력해 주세요.", false);
			} else {
				$("#mainform").submit();
			}
		}

		$(document).ready(function() {
			if ("" == "Y") {
				fn.inputMsg("#PWD", "비밀번호를 정확히 입력해 주세요.", false);
			}
		});
	</script>
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
