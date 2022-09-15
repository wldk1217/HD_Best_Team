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
		
		//String email = (String) session.getAttribute("memberEmail");	
	    
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    System.out.println(name + " "+ email);
	    int checked = memberDAO.findID(name, email);
	    
	    if(checked == 1){
	    	checked = Integer.parseInt(request.getParameter("1"));
	    }else {
	    	checked = Integer.parseInt(request.getParameter("0"));
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
