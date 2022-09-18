<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/mypage/updateMember.css" />

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
			<!-- nav -->
			<jsp:include page="nav.jsp"/>
			<section class="conarea">
				<h3 class="tit line">회원정보 변경</h3>
				<form name="mainform" method="post"
					action="tohomeServlet?command=mypage_update">
					<fieldset class="form-field">
						<legend>회원정보</legend>

						<dl>
							<dt>
								이름<span class="need">*<span class="hide">필수</span></span>
							</dt>
							<dd>${member.memberName}</dd>
						</dl>

						<dl>
							<dt>
								아이디<span class="need">*<span class="hide">필수</span></span>
							</dt>
							<dd>${member.memberId}</dd>
						</dl>

						<!-- 20200407// -->

						<!-- H.Point 통합회원 비밀번호 변경// -->
						<dl class="hpointpw">
							<dt>
								비밀번호<span class="need">*<span class="hide">필수</span></span>
							</dt>
							<dd>
								<label class="form-entry"> <input type="password"
									name="memberPw" id="memberPw" title="비밀전호 입력"
									placeholder="비밀번호" />
									<button type="button" class="btn-del" tabindex="-1">
										삭제</button>
								</label>
							</dd>
						</dl>
						<!-- //H.Point 통합회원 비밀번호 변경 -->

						<!-- //20200420 -->

						<dl>
							<dt>
								휴대폰번호<span class="need">*<span class="hide">필수</span></span>
							</dt>
							<dd>
								<label class="form-entry"> <input type="text"
									name="memberTel" id="memberTel" title="전화번호 입력"
									placeholder="전화번호" value="${member.memberTel}" />
									<button type="button" class="btn-del" tabindex="-1">
										삭제</button>
								</label>
							</dd>
						</dl>

						<dl class="email-info">
							<dt>
								이메일<span class="need">*<span class="hide">필수</span></span>
							</dt>
							<dd>
								<label class="form-entry"> <input type="text"
									name="memberEmail" id="memberEmail" title="이메일 입력"
									placeholder="이메일" value="${member.memberEmail}" />
									<button type="button" class="btn-del" tabindex="-1">
										삭제</button>
								</label>
							</dd>
						</dl>

						<input type="hidden" name="POST_NO" value="" /> <input
							type="hidden" name="BASE_ADR" value="" /> <input type="hidden"
							name="PTC_ADR" value="" /> <input type="hidden" name="ADR_GBCD"
							value="10" /> <input type="hidden" name="BASE_YN" value="Y" />
						<dl>
							<dt>주소</dt>
							<dd>
								<label class="form-entry"> <input type="text"
									name="memberAdderss" id="memberAdderss" title="주소 입력"
									placeholder="주소" value="${member.memberAdderss}" />
									<button type="button" class="btn-del" tabindex="-1">
										삭제</button>
								</label>

							</dd>
						</dl>

						<input type="hidden" name="PUSH_RCV_AGR_YN" /> <input
							type="hidden" name="SMS_RCV_AGR_YN" /> <input type="hidden"
							name="EMAIL_RCV_AGR_YN" />

						<!-- 평생회원인 경우 해당 영역 비노출// -->

						<!-- //평생회원인 경우 해당 영역 비노출 -->

						<!--
                            메세지 띄우기 : fn.inputMsg('input ID명', '에러 메세지'); / fn.inputMsg('input ID명', '긍정 메세지', true);
                            특정 메세지 지우기 : fn.inputMsgClear('input ID명');
                            전체 메세지 지우기 : fn.inputMsgClear();
                            input 전체 입력할 경우 : button disabled 해제
                        -->
						<div class="btns">
							
							<button type="submit" class="btn fill big black">정보변경</button>
						</div>
					</fieldset>

					<!-- 현대식품관 전용회원인경우에만 통합회원 영역 노출// -->
					<fieldset class="hpointchange-field" id="hpointNoMem"
						style="display: none">
						<legend class="hide">H.Point 통합회원</legend>
						<!-- 20200407// -->
						<div class="info">
							<h3>H.Point 통합회원 전환 안내</h3>
							<p>현대백화점그룹 H.Point 통합회원으로 전환하고 멤버십 혜택과 다양한 서비스를 하나의 아이디로
								누리세요!</p>
							<a href="javascript:checkCi();" class="btn-round">H.Point
								통합회원 전환하기</a>
						</div>

						<p class="txt-exclaim">동의하실 경우 다음의 정보가 공유됩니다.</p>
						<p>제공받는자 : ㈜현대백화점, 목적 : 회원가입 시 필수정보 입력, 기 가입여부, 타인과의 아이디 중복여부
							확인, 항목 : 이름, 휴대폰번호, 생년월일, CI</p>
						<!-- //20200407 -->
					</fieldset>
					<!-- //현대식품관 전용회원인경우에만 통합회원 영역 노출 -->
				</form>

				<div class="withdrawal-area">
					<p>탈퇴를 원하신다면?</p>
					<a href="/front/cua/mypage/leaveMemberForm.do" class="btn-line">회원탈퇴</a>
				</div>
			</section>
		</div>
	</div>
	
	<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>

</body>
</html>
