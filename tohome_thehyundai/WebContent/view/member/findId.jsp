<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./findId.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" />
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
<title>Document</title>
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
			<a href="./loginForm.jsp">로그인</a> <a href="./membership.jsp">회원가입</a> <a href="">마이페이지</a> <a
				href="">고객센터</a>
		</div>
	</header>
	
	<!-- 로그인 폼  -->
	<div class="find-input-form">
		<h2>아이디찾기</h2><br>
		<form>
			<ul>
				<li style="margin-bottom: 10px;">
					<label class="form-entry">
						<div class="item">이름</div>
						<div class="item">
							<input type="text" id="name" name="name" class="big" title="이름 입력" placeholder="이름">
						</div>
					</label>
					<label class="form-entry">
						<div class="item">이메일</div>
						<div class="item">
							<input type="text" id="email" name="email" class="big" title="이메일 입력" placeholder="이메일">
						</div>
					</label>
				</li>
			</ul>
			<div class="find-btn">
				<li>
					<button type="button" class="find-btn-btn" style="margin-bottom: 10px;">아이디 찾기</button>
				</li>
			</div>
			<ul class="login-surport">
				<li class="login-sub">
					<a href="./findPw.jsp">비밀번호 찾기</a>
				</li>
			</ul>
		</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
	AOS.init();
</script>
</html>