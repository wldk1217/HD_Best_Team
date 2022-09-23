/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그아웃
public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃 후 반환할 url
		String url = "tohomeServlet?command=index";

		// 현재 세션이 존재하면 기존 세션 리턴, 기존 세션이 없다면 null값을 리턴
		HttpSession session = request.getSession(false);
		
		// 세션이 null이 아닐 때 설정된 모든 세션 제거
		if (session != null) {
			session.invalidate();
		}
		
		// request에 담긴 정보를 다음페이지에 전달
		request.getRequestDispatcher(url).forward(request, response);
	}
}
