package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

public class MyPageUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memberId");
		
		String pw = request.getParameter("memberPw");
		String tel = request.getParameter("memberTel");
		
		String email =request.getParameter("memberEmail");
		String address = request.getParameter("memberAdderss");
//		System.out.println(id + " " +pw + " " + tel + " " + email + " " + address);
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMember(id, pw, tel, email, address);
		response.sendRedirect("tohomeServlet?command=mypage_update_from");
	}

}
