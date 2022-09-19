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

						<div class="btns">
							
							<button type="submit" class="btn fill big black">정보변경</button>
						</div>
					</fieldset>
				</form>

				<div class="withdrawal-area">
					<p>탈퇴를 원하신다면?</p>
					<a href="tohomeServlet?command=mypage_member_delete" class="btn-line">회원탈퇴</a>
				</div>
			</section>
		</div>
	</div>
	
	<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>

</body>
</html>
