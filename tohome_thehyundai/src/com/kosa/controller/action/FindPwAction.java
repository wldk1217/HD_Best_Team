package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

public class FindPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/member/findId_fail.jsp";

		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		System.out.println(id + " " + email+ " "+tel);
		String memberPw = memberDAO.findPW(id, email, tel);

		if (memberPw != "") {
			url = "tohomeServlet?command=find_pw_result&memberPw=" + memberPw;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
