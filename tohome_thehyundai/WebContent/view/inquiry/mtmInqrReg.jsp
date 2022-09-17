<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="view/inquiry/mtmInqrReg.css" />
  <link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
   crossorigin="anonymous"
   />
    <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
	crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
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

        <div class="infotxt">
          <p>당일 16시 이후 접수 건은 익일 오전 9시 이후 답변 가능</p>
          <p>(주말, 공휴일 제외)</p>
        </div>

        <div class="customerform">
          <form class="inqrForm" id="inquiry_insert" method="post" name="formm">
            <div class="form-filter">
              <p>문의 분야</p>
              <select name="depth1" title="문의선택" class="select_small" id="inquiry1">
                <option value="배송문의">배송문의</option>
                <option value="상품문의">상품문의</option>
                <option value="파손/미수령">파손/미수령</option>
                <option value="회수문의">회수문의</option>
                <option value="기타문의">기타문의</option>
              </select>
            </div>

            <div class="contentsbox">
              <div class="contentstop">
                내용
                <span class="counter">
                  <em id="em1">0</em><em>/500</em>
                </span>
              </div>
              <textarea id="text1" name="cntn" title="리뷰 입력" style="padding: 10px 15px"
                placeholder="문의하실 내용을 입력해주세요.질문 내용을 구체적으로  입력해주시면 정확하고 빠른 답변에 도움이 됩니다." maxlength="500" rows="5"
                cols="80"></textarea>
            </div>

            <div class="imgcontents">
              <label class="img_label" for="file">
                <i class="bi bi-plus" style="font-size: 48px"></i>
                <input type="file" accept=".jpg .png .gif" name="uploading" class="upload-hidden" title="사진 첨부"
                  id="file" />
              </label>
              <ul>
                <li>20MB미만의 JPG, PNGM GIF 파일만 등록가능합니다.</li>
                <li>
                  상품과 무관한 내용이거나 음란 및 불법적인 내용은 통보없이
                  삭제될 수 있습니다.
                </li>
              </ul>
            </div>

            <div class="btns">
              <button type="button" class="btn-cancel" onclick="initializing()">
                취소
              </button>
              <button type="button" class="btn-confirm" onclick="go_save()">확인</button>
            </div>
          </form>
        </div>
      </section>
    </div>
  </div>
  
  <!-- footer.jsp 삽입 -->
	<jsp:include page="/footer.jsp"/>
	
</body>
<script>
  let a = document.getElementById("text1");
  a.addEventListener("keyup", function () {
    let b = document.getElementById("em1");
    b.innerText = a.value.length;
  });
  console.log(a.value.length);
</script>

<script>
  function initializing() {
    var input = document.getElementById("inquiry1");
    var text1 = document.getElementById("text1");
    input.value = null;
    text1.value = null;
  }
</script>

<script>
	function go_save() {
		if (document.formm.depth1.value == "") {
		    alert("문의 분야를 설정해주세요.");
		    document.formm.depth1.focus();
		  } else if (document.formm.cntn.value == "") {
		    alert("문의 사항을 입력해주세요.");
		    document.formm.cntn.focus();
		  } else {
		    document.formm.action = "tohomeServlet?command=inquiry_insert";
		    document.formm.submit();
		  }
	}
</script>



</html>