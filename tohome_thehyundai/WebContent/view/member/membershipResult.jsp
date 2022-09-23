<!-- 
	코드 작성자 : 김다빈
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 회운가입 성공 -->
<script>
	alert("회원이 등록되었습니다.");
	location.href = "tohomeServlet?command=login_form"
</script>