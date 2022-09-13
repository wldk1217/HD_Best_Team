<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./membership.css" />
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

	<!-- 회원가입 폼  -->
	<div class="membership-input-form">
		<form>
			<ul>
				<li class="form-text">
					<h2>회원가입</h2>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">아이디</div>
						<div class="item">
							<input type="text" id="id" name="id" class="big" title="아이디 입력" placeholder="아이디">
						</div>
						<div class="item">
							<button type="button">중복확인</button>
						</div>
					</label>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">비밀번호</div>
						<div class="item">
							<input type="password" id="pwd" name="pwd" class="big" title="비밀번호 입력" placeholder="비밀번호">
						</div>
					</label>
					<label class="form-entry">
						<div class="item">비밀번호 확인</div>
						<div class="item">
							<input type="password" id="pwd2" name="pwd2" class="big" title="비밀번호 입력" placeholder="비밀번호 확인">
						</div>
					</label>
				</li>
				<li>
					<label class="form-entry">
						<div class="item">이름</div>
						<div class="item">
							<input type="text" id="name" name="name" class="big" title="이름 입력" placeholder="이름">
						</div>
					</label>
					<label class="form-entry">
						<div class="item">닉네임</div>
						<div class="item">
							<input type="text" id="nickname" name="nickname" class="big" title="닉네임 입력" placeholder="닉네임">
						</div>
						<div class="item">
							<button type="button">중복확인</button>
						</div>
					</label>
					<label class="form-entry">
						<div class="item">이메일</div>
						<div class="item">
							<input type="text" id="email" name="email" class="big" title="이메일 입력" placeholder="이메일     ex) hyundai@google.com">
						</div>
						<div class="item">
							<button type="button">중복확인</button>
						</div>
					</label>
					<label class="form-entry">
						<div class="item">성별</div>
						<div class="item2">
							<input type="radio" id="woman" name="sex" value="woman">&nbsp&nbsp여 &nbsp&nbsp&nbsp&nbsp
							<input type="radio" id="man" name="sex" value="man">&nbsp&nbsp남
						</div>
					</label>
					<label class="form-entry"> 
						<div class="item">생년월일</div>
						<div class="item">
							<input type="date" id="birth" name="birth" value="birth">
						</div>
					</label> <br><br>
					
					<div class="membership-btn">
						<button type="button" class="btn fill big black text-white">회원가입</button>
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