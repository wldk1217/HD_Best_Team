package com.kosa.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.MemberDAO;

public class NickCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberNickname = request.getParameter("nickname");
		System.out.println(memberNickname);

		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		String nickCheck = user.nickCheck(memberNickname);
		System.out.println(nickCheck);

		if (nickCheck.length() == 0 || nickCheck.equals(null)) {
			System.out.println("사용 가능한 닉네임");
		} else {
			System.out.println("이미 존재하는 닉네임");
		}
		out.write(nickCheck+"");

	}

}
