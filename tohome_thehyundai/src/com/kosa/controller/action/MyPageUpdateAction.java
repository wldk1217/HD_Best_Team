package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.MemberDAO;

//회원 정보 수정
public class MyPageUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		BasketDAO basketDAO = BasketDAO.getInstance();
		
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("basketCount", basketDAO.countBasket(loginUser));
		
		
		String pw = request.getParameter("memberPw");
		String tel = request.getParameter("memberTel");
		
		String email =request.getParameter("memberEmail");
		String address = request.getParameter("memberAdderss");
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMember(loginUser, pw, tel, email, address);
		response.sendRedirect("tohomeServlet?command=mypage_update_form");
	}

}
