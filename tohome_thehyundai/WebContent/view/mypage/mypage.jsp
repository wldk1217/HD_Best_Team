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
<title>Mypage</title>
</head>

<body>

<!-- header.jsp 삽입 -->
	<jsp:include page="/header.jsp"/>

	<div class="contents">
		<div class="innercon">
			<!-- nav -->
			<jsp:include page="nav.jsp"/>
			
			
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
