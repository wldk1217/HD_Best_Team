package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.MemberVO;
import com.kosa.model.MemberDAO;

public class MyPageUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/updateMember.jsp";
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memberId");

		MemberDAO memberDAO = MemberDAO.getInstance();

		MemberVO memberVO = memberDAO.selectMember(id);

		request.setAttribute("member", memberVO);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
