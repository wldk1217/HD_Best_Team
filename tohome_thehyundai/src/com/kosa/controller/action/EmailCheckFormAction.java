/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.MemberDAO;

// 이메일 중복 확인
public class EmailCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션에 있는 "email 값을 email 변수에 저장
		String memberEmail = request.getParameter("email");
		System.out.println(memberEmail);

		// servlet으로 들어온 요청을 파악 후 텍스트 형태로 출력
		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();
		
		// memberEamil 값으로 memberDAO의 emailCheck를 통해 반환된 값을 emailCheck에 저장
		String emailCheck = user.emailCheck(memberEmail);
		System.out.println(emailCheck);

		// emailCheck의 길이가 0, null이면 사용 가능 아니면 불가능
		if (emailCheck.length() == 0 || emailCheck.equals(null)) {
			System.out.println("사용 가능한 이메일");
		} else { 
			System.out.println("이미 존재하는 이메일");
		}
		
		out.write(emailCheck+"");

	}

}
