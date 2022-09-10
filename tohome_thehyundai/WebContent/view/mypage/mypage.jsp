<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./mypage.css" />
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
    <div class="innercon">
        <!-- mypage lnb// -->
        











<script type="text/javascript">
  var custTndcGbcd = '99';
  $(document).ready(function(){
      if( window.location.pathname.toString().indexOf("prmsBoxList") > -1 ) $("li[name=prmsBoxList]").addClass("active");
      $('#esuperlist.active a').css('color','#adc71c');
      
      $('#esuperlist').hover(function(){
    	  $('#esuperlist a').css('color','#adc71c');  
      },function(){
    	  if($('#esuperlist').hasClass('active') === true){
		      $('#esuperlist.active a').css('color','#adc71c');
    	  } else {
	    	  $('#esuperlist a').css('color','#767572');
    	  }
      })
      
  });
  
  function fn_mtmInqrClick() {
	  if(custTndcGbcd == "20" || custTndcGbcd == "30" || custTndcGbcd == "40" || custTndcGbcd == "50") {
		  alert("1:1 웹문의 접수가 불가합니다. 문의사항은 고객센터 전화상담을 이용해주시기 바랍니다.");
		  return false;
	  }
	  else {
		  location.href = "/front/mp/mpc/mtmInqrList.do";
	  }
  }
  function fn_GaEvent(dpth) {
	  GA_Event('PC_마이페이지','LNB', $(dpth).closest("ul").prev().text()+'_'+$(dpth).text());
  }
</script>
<section class="lnbarea">
    <h2>마이페이지</h2>
    <ul>
        <li class="lnb-depth1">
            <a href="#">주문관리</a>
            <ul class="lnb-depth2">
                <li><a href="/front/od/odd/orderList.do" onclick="fn_GaEvent(this);">주문 내역</a></li>
                <li id="esuperlist"><a href="/front/od/odd/orderList.do?mpGb=E&amp;searchOrdGbcd=E" onclick="fn_GaEvent(this);" style="color: rgb(118, 117, 114);">주문 내역(e슈퍼마켓)</a></li><!-- 20220412 김민서 [e슈퍼이관] e슈퍼 링크 추가 -->
                <li><a href="/front/od/odd/orderCnclList.do" onclick="fn_GaEvent(this);">주문취소</a></li>
                <li><a href="/front/od/odd/orderExchRtpList.do" onclick="fn_GaEvent(this);">반품/교환</a></li>
                <li><a href="/front/od/odd/massOrdInqr.do" onclick="fn_GaEvent(this);">대량주문 문의</a></li>
                <li><a href="/front/od/odd/prmsSbScrptnList.do" onclick="fn_GaEvent(this);">투홈구독</a></li>
                <li><a href="/front/od/odd/rintrvDlvList.do" onclick="fn_GaEvent(this);">정기배송 설정</a></li>
            </ul>
        </li>

        <li class="lnb-depth1">
            <a href="#">쇼핑 혜택</a>
            <ul class="lnb-depth2">
                <li><a href="/front/mp/mpb/couponList.do" onclick="fn_GaEvent(this);">쿠폰</a></li>
                <li><a href="/front/mp/mpb/hBonus.do" onclick="fn_GaEvent(this);">H.Bonus</a></li>
                <li><a href="/front/cub/mypage/paidService.do" onclick="fn_GaEvent(this);">투홈패스</a></li>
                <li><a href="/front/mp/mpb/hPoint.do" onclick="fn_GaEvent(this);">H.Point</a></li>
                
                <li><a href="/front/cua/mypage/cdpst.do" onclick="fn_GaEvent(this);">상품권 전환금</a></li>
            </ul>
        </li>
        <li class="lnb-depth1">
            <a href="#">나의 활동</a>
            <ul class="lnb-depth2">
                <li><a href="/front/mp/mpb/myReview.do" onclick="fn_GaEvent(this);">리뷰</a></li>
                <li><a href="/front/mp/mpb/myLike.do" onclick="fn_GaEvent(this);">좋아요</a></li>
                <li><a href="/front/mp/mpb/recentViewSlitm.do" onclick="fn_GaEvent(this);">최근 본 상품</a></li>
                
                <li><a href="javaScript:fn_mtmInqrClick();" onclick="fn_GaEvent(this);">1:1 문의내역</a></li>
                <li><a href="/front/dp/dpd/mgzStorageMain.do" onclick="fn_GaEvent(this);">매거진 보관함</a></li>
                <li><a href="/front/mp/mpb/purchasingProduct.do" onclick="fn_GaEvent(this);">늘 필요한 상품</a></li>
                
                <li><a href="/front/mp/mpb/evntEntryCrst.do" onclick="fn_GaEvent(this);">이벤트 참여현황</a></li>
                <li><a href="/front/mp/mpa/homeBasketMng.do" onclick="fn_GaEvent(this);">투홈백 관리</a></li>
                <li><a href="/front/mp/mpb/rishpNotf.do" onclick="fn_GaEvent(this);">재입고 알림</a></li>
            </ul>
        </li>
        <li class="lnb-depth1">
            <a href="#">나의 정보</a>
            <ul class="lnb-depth2">
                <li><a href="/front/cua/mypage/certPwd.do" onclick="fn_GaEvent(this);">회원정보 변경</a></li>
                <li><a href="/front/od/odd/shippingList.do" onclick="fn_GaEvent(this);">배송지 관리</a></li>
                <!-- <li><a href="#">간편계정연결관리</a></li> -->
                <li><a href="/front/cua/mypage/loginHistList.do" onclick="fn_GaEvent(this);">로그인 기록</a></li>
                
                <li><a href="/front/od/odd/hpointPayMethodMng.do" onclick="fn_GaEvent(this);">H.Point Pay</a></li>
                
                <li><a href="/front/od/odd/stlmWayMng.do" onclick="fn_GaEvent(this);">Home Pay</a></li>
                <li><a href="/front/cua/mypage/personalInfoUseStatus.do" onclick="fn_GaEvent(this);">개인정보 이용현황</a></li>
                <li><a href="/front/cua/mypage/cashinfo.do" onclick="fn_GaEvent(this);">환불계좌/현금영수증</a></li>
                <li><a href="/front/cua/front/staffCertify.do" onclick="fn_GaEvent(this);">임직원 인증</a></li>
                <li><a href="/front/cua/mypage/custCarInfo.do" onclick="fn_GaEvent(this);">차량 등록</a></li>
                
            </ul>
        </li>

    </ul>
</section> 
    
    

        <!-- //mypage lnb -->

        <section class="conarea">
            <h3 class="hide">마이페이지</h3>

            <section class="mystate-section">
                <div class="myinfo">
                
                    
	                    
	                    
	                    
	                    
	                    
	                        
	                                       
	                
                
                    <div class="memclass normal">

                        
                        
                        <div class="cont">
                            <strong class="name">신기원님</strong>
                            
		                    
		                    
		                    
		                    
		                    
                            
                            <ul>
                                <li><a href="/front/cua/mypage/certPwd.do" class="btn-line" onclick="GA_Event('PC_마이페이지','회원정보','회원정보');">회원정보</a></li>
                                <li><a href="#" class="btn-line" onclick="fn.popupOpen('#p_popGradeBenefit');GA_Event('PC_마이페이지','회원정보','멤버십 혜택');">멤버십 혜택</a></li>
                                
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="point">
                    <ul>
                        
                        <li>
                            <a href="/front/mp/mpb/couponList.do" onclick="GA_Event('PC_마이페이지','회원정보','쿠폰');">
                                <div class="inner">
                                    <strong><span id="cupnCnt">2</span>장</strong> 쿠폰
                                </div>
                            </a>
                        </li>
                        
                        
                        
                        <li>
                            <a href="/front/mp/mpb/hBonus.do" onclick="GA_Event('PC_마이페이지','회원정보','H.Bonus');">
                                <div class="inner">
                                    <strong><span id="curHBonus">0</span>B</strong> H.Bonus
                                </div>
                            </a>
                        </li>
                        
                        
                        
                        
                        <li>
                           <a href="/front/mp/mpb/hPoint.do" onclick="GA_Event('PC_마이페이지','회원정보','H.Point');">
                               <div class="inner">
                                   <strong><span id="upointCurAmt">1,163</span>P</strong> H.Point
                               </div>
                           </a>
                        </li> 
                        
                        
                        
                       
                        <li>
                            <a href="/front/cua/mypage/cdpst.do" onclick="GA_Event('PC_마이페이지','회원정보','상품권 전환금');">
                                <div class="inner">
                                    <strong><span id="curAmt">0</span>원</strong> 상품권 전환금
                                </div>
                            </a>
                        </li>
                       
                        <li>
                            <a href="/front/pd/pde/myReview.do" onclick="GA_Event('PC_마이페이지','회원정보','상품리뷰');">
                                <div class="inner">
                                    <strong><span>0</span>건</strong> 상품리뷰
                                </div>
                            </a>
                        </li>                       
                       
                    </ul>
                </div>
            </section>

            
            
            
            <!-- 20220406 김민서 [e슈퍼이관]
            	[기획ID : F12-1] e슈퍼마켓 상품관련 주문/배송현황 추가
            	1. 이름변경
            	2. 반품/교환 Status 삭제
            	3. 모바일과 동일하게 4주 內 이력이 있는 경우에만 활성화
            -->
            
            

            

            <section class="like-section">
                <header class="header">
                    <h4><span>좋아요 </span><strong>0</strong></h4>
                    <a href="/front/mp/mpb/myLike.do" class="btn-line" onclick="GA_Event('PC_마이페이지','좋아요','더보기');">더보기</a>
                </header>
				
				<!-- 20220509 김민서 [e슈퍼이관] [FP12] 상품이미지, 정보 삭제 및 총 좋아요 개수만 노출 -->
                
            </section>

            <section class="view-section">
                <header class="header">
                    <h4><span>최근 본 상품 </span><strong>0</strong></h4>
                    <a href="/front/mp/mpb/recentViewSlitm.do" class="btn-line" onclick="GA_Event('PC_마이페이지','최근_본_상품','더보기');">더보기</a>
                </header>

                
                    
                    
                        <div class="nodata">최근 본 상품이 없습니다.</div>
                    
                
            </section>
        </section>
    </div>
  </body>
</html>
