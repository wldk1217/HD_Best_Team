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

		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);
		
		if(memberId == null) {
			url = "tohomeServlet?command=login_form";
		}
		else {
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}