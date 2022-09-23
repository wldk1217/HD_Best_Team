/*
 * 코드 작성자 : 김다빈 
 */

// id, nick, tel, email 체크 패스 여부 변수
let idPass = false;
let nickPass = false;
let telPass = false;
let emailPass = false;

// 회원가입 버튼 클릭 시
$(function() {
	$("#join").submit(function() {
		
		// id 값이 빈칸일 때 alert 띄우기
		if ($("#id").val() == '') {
			alert("아이디를 입력하세요");
			$("#id").focus();
			return false;
		}

		// pwd 값이 빈칸일 때 alert 띄우고 pwd2와 pwd가 일치하지 않으면 alert 띄우기
		if ($("#pwd").val() == '' || $("#pwd2").val() == '') {
			alert("비밀번호를 입력하세요");
			$("#pwd").focus();
			return false;
		} else if ($("#pwd").val() != $("#pwd2").val()) {
			alert("비밀번호가 일치하지 않습니다");
			$("#pwd2").focus();
			return false;
		}
		
		// name 값이 빈칸일 때 alert 띄우기
		if ($("#name").val() == '') {
			alert("이름을 입력하세요");
			$("#name").focus();
			return false;
		}
		
		// nickname 값이 빈칸일 때 alert 띄우기
		if ($("#nickname").val() == '') {
			alert("닉네임을 입력하세요");
			$("#nickname").focus();
			return false;
		}

		// tel 값이 빈칸일 때 alert 띄우기
		if ($("#tel").val() == '') {
			alert("전화번호를 입력하세요");
			$("#tel").focus();
			return false;
		}

		// email 값이 빈칸일 때 alert 띄우기
		if ($("#email").val() == '') {
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		
		// birth 값이 빈칸일 때 alert 띄우기
		if ($("#birth").val() == '') {
			alert("생년월일을 선택하세요");
			$("#birth").focus();
			return false;
		}

		// addr 값이 빈칸일 때 alert 띄우기
		if ($("#addr").val() == '') {
			alert("주소를 입력하세요");
			$("#addr").focus();
			return false;
		}

		//----------------- 중복방지
		// 아이디중복확인
		if (!idPass) {
			alert("아이디를 확인해주세요");
			return false
		}

		// 닉네임중복확인
		if (!nickPass) {
			alert("닉네임을 확인해주세요");
			return false
		}

		// 전화번호중복확인
		if (!telPass) {
			alert("전화번호를 확인해주세요");
			return false
		}

		// 이메일중복확인
		if (!emailPass) {
			alert("이메일을 확인해주세요");
			return false
		}

		return true;
		
	});
});


$(function() {
	//아이디 중복검사
	$("#id").keyup(function() {
		console.log("아이디중복검사콘솔");
		var member_id = $("#id").val();
		idPass = false;
		if (member_id != '' && member_id.length >= 6) {

			var url = "/tohome_thehyundai/tohomeServlet?command=id_check_form";

			$.ajax({
				url: url,
				data: "id=" + member_id, // input박스에 입력한 아이디
				dataType: "text",
				type: "POST",
				success: function(result) {
					console.log("ajax result : " + result);
					console.log("member_id result : " + member_id);

					// input박스에 입력한 아이디와 #idAction의 아이디가 같으면 사용 불가능
					if (result == member_id) {//사용불가능
						$("#chk").html("이미 사용중인 아이디입니다.");
						$("#idchk").val("N");
						$("#chk").css("color", "red");
						idPass = false;
					} else {//사용가능
						$("#chk").html("사용 가능한 아이디입니다.");
						$("#idchk").val("Y");
						$("#chk").css("color", "blue")
						idPass = true;
					}
				}
			});
		} else {//사용불가
			$("#chk").html("6자 이상으로 입력해주세요.");
			$("#idchk").val("N");
			$("#chk").css("color", "red");
			idPass = false;
		}
	});
});

$(function() {
	//닉네임 중복검사
	$("#nickname").keyup(function() {
		console.log("닉네임중복검사콘솔");
		var member_nickname = $("#nickname").val();
		nickPass = false;
		if (member_nickname != '' && member_nickname.length >= 3) {

			var url = "/tohome_thehyundai/tohomeServlet?command=nick_check_form";

			$.ajax({
				url: url,
				data: "nickname=" + member_nickname, // input박스에 입력한 닉네임
				dataType: "text",
				type: "POST",
				success: function(result) {
					console.log("ajax result : " + result);
					console.log("member_nickname result : " + member_nickname);

					// input박스에 입력한 닉네임의 길이가 0보다 크면 사용 불가능
					if ( result.length > 0 ) {//사용불가능
						$("#chkN").html("이미 사용중인 닉네임입니다.");
						$("#stateNickChk").val("N");
						$("#chkN").css("color", "red");
						nickPass = false;
					} else {//사용가능
						$("#chkN").html("사용 가능한 닉네임입니다.");
						$("#stateNickChk").val("Y");
						$("#chkN").css("color", "blue")
						nickPass = true;
					}
				}
			});
		} else {//사용불가
			$("#chkN").html("3자 이상으로 입력해주세요.");
			$("#stateNickChk").val("N");
			$("#chkN").css("color", "red");
			nickPass = false;
		}
	});
});

$(function() {
	//전화번호 중복검사
	$("#tel").keyup(function() {
		console.log("전화번호중복검사콘솔");
		var member_tel = $("#tel").val();
		telPass = false;
		if (member_tel != '' && member_tel.length >= 9 && member_tel.length <= 12 ) {

			var url = "/tohome_thehyundai/tohomeServlet?command=tel_check_form";

			$.ajax({
				url: url,
				data: "tel=" + member_tel, // input박스에 입력한 전화번호
				dataType: "text",
				type: "POST",
				success: function(result) {
					console.log("ajax result : " + result);
					console.log("member_tel result : " + member_tel);

					// input박스에 입력한 전화번호의 길이가 0보다 크면 사용 불가능
					if ( result.length > 0 ) {//사용불가능
						$("#chkT").html("이미 사용중인 전화번호입니다.");
						$("#telChk").val("N");
						$("#chkT").css("color", "red");
						telPass = false;
					} else {//사용가능
						$("#chkT").html("사용 가능한 전화번호입니다.");
						$("#telChk").val("Y");
						$("#chkT").css("color", "blue")
						telPass = true;
					}
				}
			});
		} else {//사용불가
			$("#chkT").html("9~12자 사이여야 합니다. 다음과 같이 입력해주세요. </br> 예) 01011112222");
			$("#telChk").val("N");
			$("#chkT").css("color", "red");
			telPass = false;
		}
	});
});



$(function() {
	//이메일 중복검사
	$("#email").keyup(function() {
		console.log("이메일중복검사콘솔");
		var member_email = $("#email").val();
		emailPass = false;
		if (member_email != '' && member_email.length >= 8 ) {

			var url = "/tohome_thehyundai/tohomeServlet?command=email_check_form";

			$.ajax({
				url: url,
				data: "email=" + member_email, // input박스에 입력한 이메일
				dataType: "text",
				type: "POST",
				success: function(result) {
					console.log("ajax result : " + result);
					console.log("member_tel result : " + member_email);

					// input박스에 입력한 이메일의 길이가 0보다 크면 사용 불가능
					if ( result.length > 0 ) {//사용불가능
						$("#chkE").html("이미 사용중인 이메일입니다.");
						$("#EmailChk").val("N");
						$("#chkE").css("color", "red");
						emailPass = false;
					} else {//사용가능
						$("#chkE").html("사용 가능한 이메일입니다.");
						$("#EmailChk").val("Y");
						$("#chkE").css("color", "blue")
						emailPass = true;
					}
				}
			});
		} else {//사용불가
			$("#chkE").html("이메일은 아이디/비밀번호 찾기에 필요하오니 정확히 입력바랍니다.");
			$("#EmailChk").val("N");
			$("#chkE").css("color", "red");
			emailPass = false;
		}
	});
});