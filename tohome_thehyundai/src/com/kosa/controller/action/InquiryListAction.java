package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.entity.InquiryVO;
import com.kosa.model.InquiryDAO;


public class InquiryListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/inquiry/customerCenterMain.jsp";
		
		InquiryDAO inquiryDAO = InquiryDAO.getInstance();
	
		String member_id = request.getParameter("member_id");
		
		ArrayList<InquiryVO> inquiryList = inquiryDAO.viewInquiry(member_id);
		
		request.setAttribute("inquiryList", inquiryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
