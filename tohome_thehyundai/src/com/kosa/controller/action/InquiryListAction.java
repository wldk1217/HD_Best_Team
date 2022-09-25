/*
 * 코드 작성자 : 김민석
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.InquiryVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.InquiryDAO;

public class InquiryListAction implements Action {

	//문의'조회하기' 요청(request)를 받아 dao를 통해 조회처리한 후 url 페이지로 forward 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 고객센터(문의)메인페이지 url
		String url = "view/inquiry/customerCenterMain.jsp";
		
		// 세션 객체 생성
		HttpSession hs = request.getSession();
		
		//문의DAO 인스턴스 생성
		InquiryDAO inquiryDAO = InquiryDAO.getInstance();
		//헤더 카테고리DAO 인스턴스 생성
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		
		// 세션에 있는 회원 Id값을 변수에 저장
		String memberId = (String) hs.getAttribute("memberId");

		//장바구니 DAO 인스턴스 생성
		BasketDAO basketDAO = BasketDAO.getInstance();
		//request객체에 장바구니 set
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		
		ArrayList<InquiryVO> inquiryList = inquiryDAO.viewInquiry(memberId);
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();

		
		request.setAttribute("inquiryList", inquiryList);
		request.setAttribute("categoryList", categoryList);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}