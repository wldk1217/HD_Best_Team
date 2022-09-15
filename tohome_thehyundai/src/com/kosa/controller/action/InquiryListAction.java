package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.InquiryVO;
import com.kosa.model.InquiryDAO;


public class InquiryListAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String url = "view/inquiry/customerCenterMain.jsp";
      
      HttpSession hs = request.getSession();
      InquiryDAO inquiryDAO = InquiryDAO.getInstance();
   
      String memberId = (String)hs.getAttribute("memberId");
      
      ArrayList<InquiryVO> inquiryList = inquiryDAO.viewInquiry(memberId);
      
      request.setAttribute("inquiryList", inquiryList);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);

   }

}