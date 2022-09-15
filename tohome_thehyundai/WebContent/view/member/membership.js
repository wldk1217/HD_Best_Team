/**
 * 
 */
let idPass = false;

function MemberCheck() {
	let member_id = document.getElementById("id");
	if (member_id.value == '') {
		alert("아이디를 입력하세요");
		member_id.focus();
		return false;
	}
	
	if(!idPass) {
		alert("아이디를 확인해주세요");
		return false;
	}
}

$(function() {
	//아이디 중복검사
	$("#id").keyup(function() {
		var member_id = $("#id").val();
		idPass = false;
		if (member_id != '' && member_id.length >= 6) {
			var url = "/tohome_thehyundai/tohomeServlet?command=IdCheckForm";
			$.ajax({
				url: url,
				data: "id=" + member_id,
				type: "POST",
				success: function(result) {
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