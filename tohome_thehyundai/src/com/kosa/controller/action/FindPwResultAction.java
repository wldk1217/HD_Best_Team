/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비밀번호 찾기 결과
public class FindPwResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 비밀번호 찾기 후 반환될 url
		String url = "view/member/findPwResult.jsp";
		
		// 세션에 있는 "memberPw"를  memberPw 변수에 저장
		String memberPw = request.getParameter("memberPw");

		System.out.println(memberPw);

		// 세션의 "memberPw"에 memberPw 값 저장
		request.setAttribute("memberPw", memberPw);
		
		// request에 담긴 정보를 다음페이지에 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
