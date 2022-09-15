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

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("idCheck 왔는감?");
		String memberID = request.getParameter("id");
		System.out.println(memberID);

		MemberDAO member = new MemberDAO();

		MemberVO IDCheck = member.idCheck(memberID);
		
		if(IDCheck.getMemberId() != null) {
			System.out.println("이미 존재 아이디");
		} else {
			System.out.println("사용 가능 아이디");
		}

		request.setAttribute("idchk", IDCheck); // ajax에 결과값으로 보냄
	
	}
}
