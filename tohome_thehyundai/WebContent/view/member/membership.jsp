<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/member/membership.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<!-- JQuery 로드 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Document</title>
<script type="text/javascript" src="view/member/membership.js"></script>
</head>
<body>
	<!-- header -->
	<header class="header">
		<h1 class="logo">
			<a href="/mainPage.html"> <img
				src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/common/header_logo_freex34.png"
				alt="logo" />
			</a>
		</h1>

		<div class="util">
			<a href="tohomeServlet?command=login_form">로그인</a> 
			<a href="tohomeServlet?command=join_form">회원가입</a> 
			<a href="">마이페이지</a> 
			<a href="">고객센터</a>
		</div>
	</header>

	<!-- 회원가입 폼  -->
	<div class="membership-input-form">
		<form id="join" action="/tohome_thehyundai/tohomeServlet?command=join" method="post"
			name="formm" onsubmit="MemberCheck() ">
			<ul>
				<li class="form-text">
					<h2>회원가입</h2>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">아이디</div>
						<div class="item">
							<input type="text" id="id" name="id" class="big" title="아이디 입력" placeholder="아이디">
							<input type="text" id="idAction" name="idAction" value="${idAction }">${idAction }
							<span id='chk'></span>
							<input type="text" id='idchk' value="N" style="display:none;">
						</div>
					</label>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">비밀번호</div>
						<div class="item">
							<input type="password" id="pwd" name="pwd" class="big"
								title="비밀번호 입력" placeholder="비밀번호">
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">비밀번호 확인</div>
						<div class="item">
							<input type="password" id="pwd2" name="pwd2" class="big"
								title="비밀번호 입력" placeholder="비밀번호 확인">
						</div>
					</label>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">이름</div>
						<div class="item">
							<input type="text" id="name" name="name" class="big"
								title="이름 입력" placeholder="이름">
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">닉네임</div>
						<div class="item">
							<input type='text' name='nickname' id='nickname' class="big" title="아이디 입력" placeholder="아이디"/>
						<span id='chkN'></span>
						<input type="text" id='stateNickChk' value="N" style="display:none;">
						</div>
					</label>
					<label class="form-entry">
						<div class="item">전화번호</div>
						<div class="item">
							<input type='text' name='tel' id='tel' class="big" placeholder='ex) 01011112222'/> 
							<span id='chkT'></span> 
							<input type="text" id='telChk' value="N" style="display: none;">
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">이메일</div>
						<div class="item">
							<input type='text' name='email' id='email' class="big" placeholder='ex) goguma@naver.com'/><br>
							<span id='chkE'></span>
							<input type="text" id='EmailChk' value="N" style="display:none;">
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">성별</div>
						<div class="item2">
							<input type="radio" id="gender" name="gender" value=0 checked>&nbsp&nbsp여
							&nbsp&nbsp&nbsp&nbsp <input type="radio" id="gender" name="gender"	value=1>&nbsp&nbsp남
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">생년월일</div>
						<div class="item">
							<input type="date" id="birth" name="birth" value="birth">
						</div>
					</label> 
					<label class="form-entry">
						<div class="item">주소</div>
						<div class="item">
							<input type="text" id="addr" name="addr" class="big"
								placeholder="ex) 서울특별시 강동구 68길">
						</div>
					</label> <br> <br>

					<div class="membership-btn">
						<button type="submit" onclick="MemberCheck()" class="btn fill big black text-white">회원가입</button>
					</div>
				</li>
			</ul>
		</form>
	</div>
</body>
<script>
	AOS.init();
</script>
</html>