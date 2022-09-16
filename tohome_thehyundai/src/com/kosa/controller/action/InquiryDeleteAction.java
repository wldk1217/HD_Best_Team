package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.InquiryDAO;

public class InquiryDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = "tohomeServlet?command=inquiry_list";
	    
	    String cseq = request.getParameter("cseq");
	    
	
	      System.out.println(cseq);
	      InquiryDAO inquiryDAO = InquiryDAO.getInstance();
	      inquiryDAO.deleteInquiry(Integer.parseInt(cseq));
	      System.out.println("delete 성공");
	      request.getRequestDispatcher(url).forward(request, response);
	}

}
