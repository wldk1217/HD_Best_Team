package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.MemberVO;
import com.kosa.model.MemberDAO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("joinAction 왔다!");
		String url = "view/member/membershipResult.jsp";

		HttpSession session = request.getSession();

		/*
		 * MemberVO memberVO = new MemberVO();
		 * 
		 * memberVO.setId(request.getParameter("id"));
		 * memberVO.setPwd(request.getParameter("pwd"));
		 * memberVO.setName(request.getParameter("name"));
		 * memberVO.setEmail(request.getParameter("email"));
		 * memberVO.setZipNum(request.getParameter("zipNum"));
		 * memberVO.setAddress(request.getParameter("addr1") +
		 * request.getParameter("addr2"));
		 * memberVO.setPhone(request.getParameter("phone"));
		 * 
		 * session.setAttribute("id", request.getParameter("id"));
		 * 
		 * MemberDAO memberDAO = MemberDAO.getInstance();
		 * memberDAO.insertMember(memberVO);
		 */

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

		session.setAttribute("id", request.getParameter("id"));

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.insertMember(memberVO);

		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}