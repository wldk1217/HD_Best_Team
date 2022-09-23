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

// 전화번호 중복 확인
public class TelCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션에 있는 "tel" 값을 memberTel 변수에 저장
		String memberTel = request.getParameter("tel");
		System.out.println(memberTel);

		// servlet으로 들어온 요청을 파악 후 텍스트 형태로 출력
		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		// memberTel 값으로 memberDAO의 telCheck를 통해 반환된 값을 telCheck에 저장
		String telCheck = user.telCheck(memberTel);
		System.out.println(telCheck);

		// telCheck의 길이가 0, null이면 사용 가능 아니면 불가능
		if (telCheck.length() == 0 || telCheck.equals(null)) {
			System.out.println("사용 가능한 전화번호");
		} else {
			System.out.println("이미 존재하는 전화번호");
		}
		
		out.write(telCheck+"");

	}

}
