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

		String userId = request.getParameter("id");
		System.out.println(userId);
		
		PrintWriter out = response.getWriter();
		
		MemberDAO user = new MemberDAO();
		
		String idCheck = user.idCheck(userId);
		
		System.out.println(idCheck);
		
		if(idCheck.length()==0 || idCheck.equals(null)) {
			System.out.println("사용 가능한 아이디");
		}else {
			System.out.println("이미 존재하는 아이디");
		}
		out.write(idCheck+"");
		
		
		
		/*
		 * System.out.println("idCheck 왔는감?");
		 * 
		 * // 중복 id가 있을 때, 실패 String url = "view/member/membership.jsp";
		 * 
		 * MemberDAO memberDAO = MemberDAO.getInstance(); String id =
		 * request.getParameter("id"); System.out.println(id);
		 * 
		 * String result = memberDAO.idCheck(id);
		 * 
		 * request.setAttribute("idAction", result); System.out.println("result : " +
		 * result);
		 */
//		String scs = "yes";
//		
//		if( id.equals(result) ) {
//			scs = "no";
//		}
//		System.out.println(scs);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(result);
//		dispatcher.forward(request, response);
		
	}
}
