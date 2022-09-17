<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />


  <!-- CSS only -->
    <link rel="stylesheet" href="view/inquiry/customerCenterMain.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous">
    </script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
  
   <title>Here is header</title>
</head>

<body id="body">

<!-- header.jsp 삽입 -->
	<jsp:include page="/header.jsp"/>
	
  <div class="contents">
    <div class="innercon">
      <section class="lnbarea">
        <h2>고객센터</h2>
        <ul>
          <li class="lnb-depth1">
            <a href="https://www.naver.com">자주하는 질문</a>
          </li>
          <li class="lnb-depth1">
            <a href="https://www.naver.com">1:1 문의</a>
          </li>
        </ul>
      </section>
      <section class="conarea">
        <div class="link-list">
          <div class="cs">
            <h2>현대식품관 상담톡</h2>
            <p>평일 08:00 ~ 20:00</p>
          </div>
          <div class="inquiry-wrapper">
            <div class="inquiry">
              <div class="chat-icon">
                <i class="bi bi-chat-dots" style="font-size: 30px; margin-right: 10px"></i>
              </div>
              <div>
                <a href="tohomeServlet?command=inquiry_moveform">
                <p>1:1문의하기</p>
                </a>
                <small>쉽고 편리하게 문의하세요.</small>
              </div>
            </div>
            <div class="inquiry-list">
              <div class="chat-icon">
                <i class="bi bi-card-list" style="font-size: 32px; margin-right: 15px"></i>
              </div>
              <div>
                <p>1:1문의내역</p>
                <small>문의 내역을 지금 확인하세요.</small>
              </div>
            </div>
          </div>
      
       <div class="inquiryList">
       <form name="formm" method="post">
       <c:forEach items="${inquiryList}" var="InquiryVO" varStatus="status">
          <div class="inquiry-history">
            <div class="info">
              <input type="number" name="cseq" value= "${InquiryVO.quiryId}" style="display: none"> 
              <span class="inquirytype">${InquiryVO.quiryType}</span>
            </div>
            <div class="text-wrapper">
              <div class="text-answer">
                <p>${InquiryVO.quiryContent}</p>
              </div>
              <div class="text-date">
                <p>${InquiryVO.quiryDate}</p>
                <i class="bi bi-arrow-down-short" style="font-size: 32px" id="arrow-down${status.index}" onClick="ft(this.id)"></i>
              </div>
            </div>
          </div>
          <div class="inquiry-answer" id="inquiry-answer${status.index}">
            <p>
              A. 문의에 대한 답변을 준비중입니다. 빠른 답변을 드릴 수 있도록
              노력하겠습니다.
            </p>
            <button class="delete_inquiry_btn" onclick="function_delete()">
              삭제
            </button>
          </div>
          </c:forEach>
          </form>
         </div>
          
        </div>
      </section>
    </div>
  </div>

<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
	
</body>
<script>
 function ft(MyId){
	 	var str = MyId;
	 	str = str.substr(10);
    	const arrowDown = document.getElementById(MyId);
        const inquiryAnswer = document.getElementById("inquiry-answer" + str);
        arrowDown.addEventListener("click", () => {
            if (inquiryAnswer.style.display == "block") {
                inquiryAnswer.style.display = "none";
                return;
            }
            inquiryAnswer.style.display = "block";
        });
 }
</script>

<script>
function function_delete() {
	    document.formm.action = "tohomeServlet?command=inquiry_delete";
	}
</script>

</html>