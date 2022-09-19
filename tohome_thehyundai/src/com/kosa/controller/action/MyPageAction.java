package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.MemberVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;

//마이페이지 연결
public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/mypage.jsp";
		
		HttpSession session = request.getSession();
		
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		BasketDAO basketDAO = BasketDAO.getInstance();
		
		String loginUser = (String) session.getAttribute("memberId");
		
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("basketCount", basketDAO.countBasket(loginUser));

		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		} else{
			
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}
