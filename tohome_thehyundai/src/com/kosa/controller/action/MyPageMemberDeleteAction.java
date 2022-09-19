package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

public class MyPageMemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=index";
		
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.deleteMember(loginUser);
		
		if (session != null) {
			session.invalidate();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
