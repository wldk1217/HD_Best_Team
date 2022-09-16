package com.kosa.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.MemberDAO;

public class TelCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberTel = request.getParameter("tel");
		System.out.println(memberTel);

		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		String telCheck = user.telCheck(memberTel);
		System.out.println(telCheck);

		if (telCheck.length() == 0 || telCheck.equals(null)) {
			System.out.println("사용 가능한 전화번호");
		} else {
			System.out.println("이미 존재하는 전화번호");
		}
		out.write(telCheck+"");

	}

}
