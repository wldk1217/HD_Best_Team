/* 
 * 작성자 : 신기원
 */
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
		
		//header의 카테코리 목록을 보여주기 위한 DAO
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		
		//header의 장바구니 표시를 위한 DAO
		BasketDAO basketDAO = BasketDAO.getInstance();
		
		String loginUser = (String) session.getAttribute("memberId");
		
		//카테고리 목록을 가져온다
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		
		//request 객체에 key value로 전달
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("basketCount", basketDAO.countBasket(loginUser));

		// 세션에 로그인한 회원Id 값이 없으면 로그인페이지로 이동
		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
