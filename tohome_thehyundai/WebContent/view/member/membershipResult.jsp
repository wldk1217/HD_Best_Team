<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${idAction != null}">
	<script>
		alert("회원이 등록되었습니다.");
		location.href="view/member/loginForm.jsp"
	</script>
</c:if>

<c:if test="${result == null }">
	<script>
		alert("회원등록 실패하였습니다.");
		history.go(-1);
	</script>
</c:if>