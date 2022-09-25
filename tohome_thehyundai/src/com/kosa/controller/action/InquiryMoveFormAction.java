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

public class InquiryMoveFormAction implements Action {

	//세션값이 없을 경우 로그인페이지로 이동시키고 세션값이 있을 경우 url페이지로 forward
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/inquiry/mtmInqrReg.jsp";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");

		//header의 장바구니 표시를 위한 DAO
		BasketDAO basketDAO = BasketDAO.getInstance();
		//request 객체에 key value로 전달
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		
		//header의 카테코리 목록을 보여주기 위한 DAO
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		//request 객체에 key value로 전달
		request.setAttribute("categoryList", categoryList);
		
		// 세션에 로그인한 회원Id 값이 없으면 로그인페이지로 이동
		if(memberId == null) {
			url = "tohomeServlet?command=login_form";
		}
		else {
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}