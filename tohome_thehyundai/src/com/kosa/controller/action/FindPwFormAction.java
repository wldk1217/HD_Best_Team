/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비밀번호 찾기 페이지
public class FindPwFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 비밀번호 찾기 페이지 url
		String url = "view/member/findPw.jsp";

		// request에 담긴 정보를 다음페이지에 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
