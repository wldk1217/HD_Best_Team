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

import com.kosa.entity.MemberVO;
import com.kosa.model.MemberDAO;

//회원가입
public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("joinAction 왔다!");
		
		// 회원 가입 후 반환될 url
		String url = "view/member/membershipResult.jsp";

		// 세션 객체를 생성
		HttpSession session = request.getSession();

		// 세션에 있는 값들을 memberVO에 저장
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(request.getParameter("id"));
		memberVO.setMemberPw(request.getParameter("pwd"));
		memberVO.setMemberName(request.getParameter("name"));
		memberVO.setMemberTel(request.getParameter("tel"));
		memberVO.setMemberBirth(request.getParameter("birth"));
		memberVO.setMemberEmail(request.getParameter("email"));
		memberVO.setMemberGender(Integer.parseInt(request.getParameter("gender")));
		memberVO.setMemberNickname(request.getParameter("nickname"));
		memberVO.setMemberAdderss(request.getParameter("addr"));

		// 세션의 "id"에 id 값 저장 
		session.setAttribute("id", request.getParameter("id"));

		MemberDAO memberDAO = MemberDAO.getInstance();
		
		// memberVO에 저장된 값으로 insertMember를 통해 회원가입
		memberDAO.insertMember(memberVO);
	
		// request에 담긴 정보를 다음페이지에 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}