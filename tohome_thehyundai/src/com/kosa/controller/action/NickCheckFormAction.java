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

// 닉네임 중복 확인
public class NickCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션에 있는 "nickname" 값을 memberNickname 변수에 저장
		String memberNickname = request.getParameter("nickname");
		System.out.println(memberNickname);

		// servlet으로 들어온 요청을 파악 후 텍스트 형태로 출력
		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		// memberNickname 값으로 memberDAO의 nickCheck를 통해 반환된 값을 nickCheck에 저장
		String nickCheck = user.nickCheck(memberNickname);
		System.out.println(nickCheck);

		// nickCheck의 길이가 0, null이면 사용 가능 아니면 불가능
		if (nickCheck.length() == 0 || nickCheck.equals(null)) {
			System.out.println("사용 가능한 닉네임");
		} else {
			System.out.println("이미 존재하는 닉네임");
		}
		
		out.write(nickCheck+"");

	}

}
