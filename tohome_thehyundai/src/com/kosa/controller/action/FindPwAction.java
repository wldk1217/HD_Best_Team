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

// 비밀번호 찾기
public class FindPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 비밀번호 찾기 실패 후 반환할 url
		String url = "view/member/findId_fail.jsp";

		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// 세션에 있는 "id", "email", "tel" 값을 각각 id, email, tel 변수에 저장
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		System.out.println(id + " " + email+ " "+tel);
		
		// id, email, tel 값을 findPw를 통해 memberPw 변수에 저장
		String memberPw = memberDAO.findPW(id, email, tel);

		// memberPw가 null값이 아닐 때 성공
		if (memberPw != "") {
			// 비밀번호 찾기 성공 후 반환할 url
			url = "tohomeServlet?command=find_pw_result&memberPw=" + memberPw;
		}
		
		// request에 담긴 정보를 다음페이지에 전달, 비밀번호 찾기 실패시 fail로/성공시 find_pw_result로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
