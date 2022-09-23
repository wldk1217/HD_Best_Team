/*
 * 작성자 : 김다빈 
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.MemberVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.MemberDAO;
import com.kosa.model.ProductDAO;

// 아이디 중복 확인
public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션에 있는 "id" 값을 userId 변수에 저장
		String userId = request.getParameter("id");
		System.out.println(userId);

		// servlet으로 들어온 요청을 파악 후 텍스트 형태로 출력
		PrintWriter out = response.getWriter();

		MemberDAO user = new MemberDAO();

		// userId 값으로 memberDAO의 idCheck를 통해 반환된 값을 idCheck에 저장
		String idCheck = user.idCheck(userId);

		System.out.println(idCheck);

		// idCheck의 길이가 0, null이면 사용 가능 아니면 불가능
		if (idCheck.length() == 0 || idCheck.equals(null)) {
			System.out.println("사용 가능한 아이디");
		} else {
			System.out.println("이미 존재하는 아이디");
		}
		
		out.write(idCheck + "");

	}
}
