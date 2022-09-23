/* 
 * 작성자 : 신기원
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

//회원 탈퇴
public class MyPageMemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 탈퇴 수행 후 반환될 url
		String url = "tohomeServlet?command=index";
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		
		// 세션에 있는 회원 Id값을 변수에 저장
		String loginUser = (String) session.getAttribute("memberId");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		//회원Id 값으로 deleteMember를 통해 회원 삭제
		memberDAO.deleteMember(loginUser);
		
		//삭제 이후 session 제거
		if (session != null) {
			session.invalidate();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
