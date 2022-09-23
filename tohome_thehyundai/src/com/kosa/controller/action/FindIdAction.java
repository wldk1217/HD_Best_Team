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

// 아이디 찾기
public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 찾기 실패 후 반환할 url
		String url = "view/member/findId_fail.jsp";
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 세션에 있는 "name", "email" 값을 각각 name, email 변수에 저장
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name + " " + email);
		
		// name, email 값으로 findID를 통해 memberId에 변수 저장
		String memberId = memberDAO.findID(name, email);

		// memberId가 null값이 아닐 때 성공
		if (memberId != "") {
			// 아이디 찾기 성공 후 반환할 url
			url = "tohomeServlet?command=find_id_result&memberId=" + memberId;
		} 

		// request에 담긴 정보를 다음페이지에 전달, 아이디 찾기 실패시 fail로/성공시 find_id_result로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
