package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.MemberDAO;

public class FindIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("memberId");	
	    
	    MemberDAO memberDAO=MemberDAO.getInstance();
	    String pwd = request.getParameter("PWD");
	    System.out.println(id + " "+ pwd);
	    int checked = memberDAO.passwordCheck(id, pwd);
	    
	    if(checked == 1){
	    	url="tohomeServlet?command=mypage_update";
	    	response.sendRedirect(url);
	      
	    }else {
	    	url="tohomeServlet?command=mypage";
	    	response.sendRedirect(url);
	    }
	    
//	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
	}

}
