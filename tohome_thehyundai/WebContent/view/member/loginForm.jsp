<!-- 
	코드 작성자 : 김다빈
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="view/member/loginForm.css" />
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
			<a href="tohomeServlet?command=index"> <img
				src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/common/header_logo_freex34.png"
				alt="logo" />
			</a>
		</h1>

		<div class="util">
			<a href="tohomeServlet?command=login_form">로그인</a> 
			<a href="tohomeServlet?command=join_form">회원가입</a> 
		</div>
	</header>

	<!-- 로그인 폼  -->
	<div class="login-input-form">
		<h2>로그인</h2><br>
		<form method="post" action="tohomeServlet?command=login">
			<ul>
				<li style="margin-bottom: 10px;">
					<label class="form-entry">
						<input type="text" id="id" name="id" class="big" placeholder="아이디">
					</label>
				</li>
				<li>
					<label class="form-entry">
						<input type="password" id="pwd" name="pwd" class="big" title="비밀번호 입력" placeholder="비밀번호">
					</label>
				</li>
			</ul>
			<ul class="btn-group login-surport">
				<li class="login-sub">
					<a href="tohomeServlet?command=join_form">회원가입</a>&nbsp&nbsp|&nbsp&nbsp
					<a href="tohomeServlet?command=find_id_form">아이디/</a>
					<a href="tohomeServlet?command=find_pw_form">비밀번호 찾기</a>
				</li>
			</ul>
			<div class="login-btn">
				<li>
					<button type="submit" class="login-btn-btn">로그인</button>
				</li>
			</div>
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