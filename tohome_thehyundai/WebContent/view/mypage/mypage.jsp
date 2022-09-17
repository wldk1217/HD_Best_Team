<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/mypage/mypage.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
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
			<section class="lnbarea">
				<h2>마이페이지</h2>
				<ul>
					<li class="lnb-depth1"><a href="#">주문관리</a>
						<ul class="lnb-depth2">
							<li><a href="tohomeServlet?command=order_list_all">주문 내역</a></li>
							<li><a href="tohomeServlet?command=order_list_cancel">주문취소</a></li>
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

<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
</body>
</html>
