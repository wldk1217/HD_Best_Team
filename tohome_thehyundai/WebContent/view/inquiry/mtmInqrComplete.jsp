<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="view/inquiry/mtmInqrComplete.css" />
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
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"
    />
    <title>Document</title>
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
          <h3 class="tit">1:1 문의</h3>
          <section class="confirmdata">
            <div class="icon_align"><i class="bi bi-check-circle"></i></div>

            <h2>1:1 문의가 신청되었습니다.</h2>
            <p>
              문의하신 사항은 담당자 검토 후 빠른 시일내에 답변 드리겠습니다.
            </p>
          </section>
          <div class="btns">
            <a href="tohomeServlet?command=inquiry_list">
              <button type="button" class="btn_goCustoerMain">
                고객센터 메인
              </button>
            </a>
          </div>
        </section>
      </div>
    </div>

<!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
	
  </body>
</html>
