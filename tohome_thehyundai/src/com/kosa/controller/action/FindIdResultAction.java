/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

// 아이디 찾기 결과
public class FindIdResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 찾기 후 반환될 url
		String url = "view/member/findIdResult.jsp";

		// 세션에 있는 "memberId"를  memberId 변수에 저장
		String memberId = request.getParameter("memberId");

		System.out.println(memberId);

		// 세션의 "memberId"에 memberId 값 저장
		request.setAttribute("memberId", memberId);

		// request에 담긴 정보를 다음페이지에 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
