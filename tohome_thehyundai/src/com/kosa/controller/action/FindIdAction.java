package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/member/findId_fail.jsp";

		MemberDAO memberDAO = MemberDAO.getInstance();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name + " " + email);
		String memberId = memberDAO.findID(name, email);

		if (memberId != "") {
			url = "tohomeServlet?command=find_id_result&memberId=" + memberId;
		} 

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
