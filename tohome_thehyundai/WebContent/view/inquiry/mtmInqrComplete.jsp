<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="view/inquiry/mtmInqrComplete.css" />
    <link rel="stylesheet" href="view/footer.css" /> 
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"
    />
    <title>Document</title>
  </head>

  <body id="body">
    <!-- header -->
    <header class="header">
      <h1 class="logo">
        <a href="/mainPage.html">
          <img
            src="https://tohome.thehyundai.com/UIUX/w/pjtCom/images/common/header_logo_freex34.png"
            alt="logo"
          />
        </a>
      </h1>
      <div class="util">
        <a href="">로그인</a>
        <a href="">회원가입</a>
        <a href="">마이페이지</a>
        <a href="">고객센터</a>
      </div>
    </header>

    <!-- global navigation bar  -->
    <ul class="gnb-list">
      <div>
        <i class="bi bi-list">카테고리 전체보기</i>
      </div>
      <li>베스트</li>
      <li>세일</li>
      <li>신상품</li>
      <li>매거진</li>
      <li>선물하기</li>
      <li>이벤트</li>
      <div class="search">
        <input type="text" />
        <div class="search-icon">
          <i class="bi bi-search"></i>
        </div>
      </div>

      <div class="cart">
        <i class="bi bi-cart fs-4"></i>
        <div class="count">
          <p>1</p>
        </div>
      </div>
    </ul>

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

    <footer id="footer">
      <div class="util">
        <div class="inner">
          <a href="">브랜드소개</a>
          <a href="">이용약관</a>
          <a href="">개인정보처리방침</a>
          <a href="">청소년보호정책</a>
          <a href="">영상기기운영방침</a>
          <a href="#body">
            <button type="button" class="top_btn">
              <i class="bi bi-arrow-up-short"></i>TOP
            </button>
          </a>
        </div>
      </div>
    </footer>
  </body>
</html>
