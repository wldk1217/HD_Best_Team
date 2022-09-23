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
import com.kosa.entity.MemberVO;

// 로그인
public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 실패 후 반환할 url
		String url = "view/member/login_fail.jsp";
		
		// 세션 객체를 생성
		HttpSession session = request.getSession();

		// 세션에 있는 "id", "pwd" 값을 각각 id, pwd 변수에 저장
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO memberDAO = MemberDAO.getInstance();

		// memberVO에 회원 id 값으로 selectMember를 통해 로그인 변수 저장
		MemberVO memberVO = memberDAO.selectMember(id);

		System.out.println(memberVO);
		
		// 회원 id 값이 null이 아니고
		if (memberVO.getMemberId() != null) {
			// 받아온 seletMember를 통해 얻어낸 pwd값과 세션 pwd 값이 같을 때 로그인 성공
			if (memberVO.getMemberPw().equals(pwd)) {
				// 세션에 저장된 "id" 값 제거
				session.removeAttribute("id");
				// 세션의 "memberId"에 selectMember를 통해 얻어낸 id 값 저장
				session.setAttribute("memberId", memberVO.getMemberId());
				
				// 로그인 성공 후 반환될 url
				url = "tohomeServlet?command=index";
			}
		}

		// request에 담긴 정보를 다음페이지에 전달, 로그인 실패시 fail로/성공시 index로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
