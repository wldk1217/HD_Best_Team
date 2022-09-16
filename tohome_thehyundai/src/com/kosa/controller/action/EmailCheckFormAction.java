package com.kosa.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.MemberDAO;

public class EmailCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberEmail = request.getParameter("email");
		System.out.println(memberEmail);

		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		String emailCheck = user.emailCheck(memberEmail);
		System.out.println(emailCheck);

		if (emailCheck.length() == 0 || emailCheck.equals(null)) {
			System.out.println("사용 가능한 이메일");
		} else {
			System.out.println("이미 존재하는 이메일");
		}
		out.write(emailCheck+"");

	}

}
