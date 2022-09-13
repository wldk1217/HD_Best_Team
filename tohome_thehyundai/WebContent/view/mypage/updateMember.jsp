<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./updateMember.css" />

    <link rel="stylesheet" href="../footer.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
    />
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet" />

    <title>Document</title>
  </head>

  <body>
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
        <a href="">로그인</a> <a href="">회원가입</a> <a href="">마이페이지</a>
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
          <h2>마이페이지</h2>
          <ul>
            <li class="lnb-depth1">
              <a href="#">주문관리</a>
              <ul class="lnb-depth2">
                <li>
                  <a
                    href="/front/od/odd/orderList.do"
                    onclick="fn_GaEvent(this);"
                    >주문 내역</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/orderCnclList.do"
                    onclick="fn_GaEvent(this);"
                    >주문취소</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/orderExchRtpList.do"
                    onclick="fn_GaEvent(this);"
                    >반품/교환</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/massOrdInqr.do"
                    onclick="fn_GaEvent(this);"
                    >대량주문 문의</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/prmsSbScrptnList.do"
                    onclick="fn_GaEvent(this);"
                    >투홈구독</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/rintrvDlvList.do"
                    onclick="fn_GaEvent(this);"
                    >정기배송 설정</a
                  >
                </li>
              </ul>
            </li>
            <li class="lnb-depth1">
              <a href="#">나의 정보</a>
              <ul class="lnb-depth2">
                <li>
                  <a
                    href="/front/cua/mypage/certPwd.do"
                    onclick="fn_GaEvent(this);"
                    >회원정보 변경</a
                  >
                </li>
                <li>
                  <a
                    href="/front/od/odd/shippingList.do"
                    onclick="fn_GaEvent(this);"
                    >배송지 관리</a
                  >
                </li>
                <!-- <li><a href="#">간편계정연결관리</a></li> -->
                <li>
                  <a
                    href="/front/cua/mypage/loginHistList.do"
                    onclick="fn_GaEvent(this);"
                    >로그인 기록</a
                  >
                </li>

                <li>
                  <a
                    href="/front/od/odd/hpointPayMethodMng.do"
                    onclick="fn_GaEvent(this);"
                    >H.Point Pay</a
                  >
                </li>

                <li>
                  <a
                    href="/front/od/odd/stlmWayMng.do"
                    onclick="fn_GaEvent(this);"
                    >Home Pay</a
                  >
                </li>
                <li>
                  <a
                    href="/front/cua/mypage/personalInfoUseStatus.do"
                    onclick="fn_GaEvent(this);"
                    >개인정보 이용현황</a
                  >
                </li>
                <li>
                  <a
                    href="/front/cua/mypage/cashinfo.do"
                    onclick="fn_GaEvent(this);"
                    >환불계좌/현금영수증</a
                  >
                </li>
                <li>
                  <a
                    href="/front/cua/front/staffCertify.do"
                    onclick="fn_GaEvent(this);"
                    >임직원 인증</a
                  >
                </li>
                <li>
                  <a
                    href="/front/cua/mypage/custCarInfo.do"
                    onclick="fn_GaEvent(this);"
                    >차량 등록</a
                  >
                </li>
              </ul>
            </li>
          </ul>
        </section>
        <section class="conarea">
          <h3 class="tit line">회원정보 변경</h3>

          <form name="mainform" method="post">
            <fieldset class="form-field">
              <legend>회원정보</legend>

              <dl>
                <dt>
                  이름<span class="need">*<span class="hide">필수</span></span>
                </dt>
                <!-- 20200407// -->
                <dd>신기원 (이름변경은 고객센터 문의)</dd>
                <!-- //20200407 -->
              </dl>

              <dl>
                <dt>
                  아이디<span class="need"
                    >*<span class="hide">필수</span></span
                  >
                </dt>
                <dd>sksrldnjs123</dd>
              </dl>

              <!-- 20200407// -->

              <!-- H.Point 통합회원 비밀번호 변경// -->
              <dl class="hpointpw">
                <dt>
                  비밀번호<span class="need"
                    >*<span class="hide">필수</span></span
                  >
                </dt>
                <dd>
                  <button
                    type="button"
                    class="btn small black"
                    onclick="javascript:window.open('/front/cua/front/updatePwdHpoint.do', 'chngWindow', 'width=500,height=650,scrollbars=no,toolbar=no,location=no,directories=no,status=no');"
                  >
                    H.Point 통합회원 비밀번호 변경</button
                  ><!-- /UIUX/w/member/pwsearch_result.html 영역 참고 : onclick="fn.popupOpen('#p_popPwResetForm');" -->
                  <input
                    type="hidden"
                    id="test1"
                    name="OLD_PWD"
                    title="기존 비밀번호 확인 입력"
                    placeholder="기존 비밀번호"
                  />
                  <input
                    type="hidden"
                    id="NEW_PWD"
                    name="NEW_PWD"
                    title="신규 비밀번호 입력"
                    placeholder="신규 비밀번호"
                    onkeydown="resetPWD();"
                  />
                  <input
                    type="hidden"
                    id="NEW_PWD2"
                    name="NEW_PWD2"
                    title="비밀번호 확인 입력"
                    placeholder="비밀번호 확인"
                    onkeydown="resetPWD();"
                  />
                  <div class="infotxt">
                    <ul>
                      <li>
                        비밀번호 변경 시 H.Point 비밀번호도 함께 변경됩니다.
                      </li>
                    </ul>
                  </div>
                </dd>
              </dl>
              <!-- //H.Point 통합회원 비밀번호 변경 -->

              <!-- //20200420 -->

              <dl>
                <dt>
                  휴대폰번호<span class="need"
                    >*<span class="hide">필수</span></span
                  >
                </dt>
                <dd>
                  <input
                    type="hidden"
                    id="TELNO"
                    name="TELNO"
                    value="01072167522"
                  />
                  <span class="dd-txt" id="TLENO_SPAN">01072167522</span>
                  <button
                    type="button"
                    class="btn small black"
                    onclick="javascript:processType=0;openMobileCert();"
                  >
                    변경
                  </button>
                  <!--
                                <div class="infotxt">
                                    <ul>
                                        <li>본인 명의의 휴대폰번호일 경우에만 변경하실 수 있습니다.</li>
                                    </ul>
                                </div>
                                <p class="desc">본인 명의의 휴대폰번호일 경우에만 변경하실 수 있습니다.</p>
                                -->
                </dd>
              </dl>

              <dl class="email-info">
                <dt>
                  이메일<span class="need"
                    >*<span class="hide">필수</span></span
                  >
                </dt>
                <dd>
                  <label class="form-entry">
                    <input
                      type="text"
                      name="EMAIL_ADR"
                      id="EMAIL_ADR"
                      title="이메일 입력"
                      placeholder="이메일"
                      value="sksrldnjs123@naver.com"
                      oninput="validEmail('EMAIL_ADR');"
                    />
                    <button type="button" class="btn-del" tabindex="-1">
                      삭제
                    </button>
                  </label>
                </dd>
              </dl>

              <input type="hidden" name="POST_NO" value="" />
              <input type="hidden" name="BASE_ADR" value="" />
              <input type="hidden" name="PTC_ADR" value="" />
              <input type="hidden" name="ADR_GBCD" value="10" />
              <input type="hidden" name="BASE_YN" value="Y" />
              <dl>
                <dt>주소</dt>
                <dd>
                  <div class="form-addr">
                    <input
                      type="text"
                      name="RDNM_POST_NO"
                      class="post"
                      title="우편번호"
                      placeholder="우편번호"
                      readonly=""
                      value=""
                    />
                    <!-- <button type="button" class="btn fill gray" onclick="javascript:fn.popupOpen('#popDeliveryAddr');">주소찾기</button> --><!-- /UIUX/w/member/join_step2_hpoint.html 영역 참고 : onclick="fn.popupOpen('#p_popDeliveryAddr');" -->
                    <button
                      type="button"
                      class="btn fill gray"
                      onclick="javascript:showSearchAddressPop('pc');"
                    >
                      주소찾기
                    </button>
                    <input
                      type="text"
                      name="RDNM_BASE_ADR"
                      title="기본주소"
                      placeholder="기본주소"
                      readonly=""
                      value=""
                    />
                    <label class="form-entry">
                      <input
                        type="text"
                        id="RDNM_PTC_ADR"
                        name="RDNM_PTC_ADR"
                        title="상세주소 입력"
                        placeholder="상세주소 입력"
                        value=""
                        onkeydown="javascript:$('#addAddrListLabel').show()"
                      /><button type="button" class="btn-del" tabindex="-1">
                        삭제
                      </button>
                    </label>
                    <label id="addAddrListLabel" style=""
                      ><input
                        type="checkbox"
                        name="ADD_DSTN"
                        id="ADD_DSTN"
                        value="Y"
                        disabled=""
                      /><span>배송지 목록에 추가</span></label
                    >

                    <div class="delivery-noti">
                      <div class="infotxt">
                        <ul>
                          <li>
                            기본 배송지 설정 및 추가/삭제/변경은 배송지 관리에서
                            가능합니다.
                          </li>
                        </ul>
                      </div>
                      <a href="/front/od/odd/shippingList.do" class="btn-round"
                        >배송지 관리</a
                      >
                    </div>
                  </div>
                </dd>
              </dl>

              <input type="hidden" name="PUSH_RCV_AGR_YN" />
              <input type="hidden" name="SMS_RCV_AGR_YN" />
              <input type="hidden" name="EMAIL_RCV_AGR_YN" />
              <dl class="marketing-info">
                <dt>마케팅 정보 수신 동의</dt>

                <dd>
                  <div class="col-input">
                    <!-- 20200421// -->
                    <label>
                      <input
                        type="checkbox"
                        id="ALL_RCV_AGR_YN_SHOW"
                        value="Y"
                        class="big"
                      />
                      <span>전체</span>
                    </label>
                    <label>
                      <input
                        type="checkbox"
                        id="PUSH_RCV_AGR_YN_SHOW"
                        value="Y"
                        onclick="javascript:pushSwap();"
                        class="big"
                      />
                      <span
                        >PUSH

                        <input
                          type="hidden"
                          id="PUSH_RCV_AGR_DT"
                          name="PUSH_RCV_AGR_DT"
                          value="20220913"
                        />
                        <p
                          class="pushdate"
                          id="pushDateDiv"
                          style="display: none"
                        >
                          (동의일자 : 2022.09.13)
                        </p>
                        <script>
                          $(document).ready(function () {
                            $("#pushDateDiv").hide();
                          });
                        </script>
                      </span>
                    </label>
                    <label>
                      <input
                        type="checkbox"
                        id="SMS_RCV_AGR_YN_SHOW"
                        value="Y"
                        class="big"
                      />
                      <span>SMS 및 카카오톡</span>
                    </label>
                    <label>
                      <input
                        type="checkbox"
                        id="EMAIL_RCV_AGR_YN_SHOW"
                        value="Y"
                        class="big"
                      />
                      <span>이메일</span>
                    </label>
                  </div>
                  <button
                    type="button"
                    class="btn-line"
                    onclick="javascript:fn.popupOpen('#popPolicyJoin12');"
                  >
                    전문보기</button
                  ><!-- /UIUX/w/member/join_step1_hpoint.html 영역 참고 : onclick="fn.popupOpen('#p_popPolicyJoin7');" -->
                </dd>
              </dl>
              <!-- 평생회원인 경우 해당 영역 비노출// -->

              <!-- //평생회원인 경우 해당 영역 비노출 -->

              <!--
                            메세지 띄우기 : fn.inputMsg('input ID명', '에러 메세지'); / fn.inputMsg('input ID명', '긍정 메세지', true);
                            특정 메세지 지우기 : fn.inputMsgClear('input ID명');
                            전체 메세지 지우기 : fn.inputMsgClear();
                            input 전체 입력할 경우 : button disabled 해제
                        -->
              <div class="btns">
                <button
                  type="button"
                  class="btn big lightgray"
                  onclick="javascript:goMypageMain();"
                >
                  취소
                </button>
                <button
                  type="button"
                  class="btn fill big black"
                  onclick="javascript:updateMember();"
                >
                  정보변경
                </button>
              </div>
            </fieldset>

            <!-- 현대식품관 전용회원인경우에만 통합회원 영역 노출// -->
            <fieldset
              class="hpointchange-field"
              id="hpointNoMem"
              style="display: none"
            >
              <legend class="hide">H.Point 통합회원</legend>
              <!-- 20200407// -->
              <div class="info">
                <h3>H.Point 통합회원 전환 안내</h3>
                <p>
                  현대백화점그룹 H.Point 통합회원으로 전환하고 멤버십 혜택과
                  다양한 서비스를 하나의 아이디로 누리세요!
                </p>
                <a href="javascript:checkCi();" class="btn-round"
                  >H.Point 통합회원 전환하기</a
                >
              </div>

              <p class="txt-exclaim">동의하실 경우 다음의 정보가 공유됩니다.</p>
              <p>
                제공받는자 : ㈜현대백화점, 목적 : 회원가입 시 필수정보 입력, 기
                가입여부, 타인과의 아이디 중복여부 확인, 항목 : 이름,
                휴대폰번호, 생년월일, CI
              </p>
              <!-- //20200407 -->
            </fieldset>
            <!-- //현대식품관 전용회원인경우에만 통합회원 영역 노출 -->
          </form>

          <div class="withdrawal-area">
            <p>탈퇴를 원하신다면?</p>
            <a href="/front/cua/mypage/leaveMemberForm.do" class="btn-line"
              >회원탈퇴</a
            >
          </div>
        </section>
      </div>
    </div>
    <footer id="footer">
      <div class="util">
        <div class="inner">
          <a href="">브랜드소개</a> <a href="">이용약관</a>
          <a href="">개인정보처리방침</a> <a href="">청소년보호정책</a>
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
