package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;
import com.kosa.entity.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login_fail.jsp";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO memberDAO = MemberDAO.getInstance();

		MemberVO memberVO = memberDAO.selectMember(id);

		if (memberVO != null) {
			if (memberVO.getMemberPw().equals(pwd)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", memberVO);
				url = "tohomeServlet?command=index";
			}
		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}
