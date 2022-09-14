package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.InquiryVO;
import com.kosa.model.InquiryDAO;

public class InquiryInsertAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String url = "view/inquiry/customerCenterMain.jsp"; 
          
          HttpSession session = request.getSession();
          
          InquiryVO inquiryVO = new InquiryVO();
          
          inquiryVO.setQuiryType(request.getParameter(""));
            
          session.setAttribute("id", request.getParameter("id"));    
          
          InquiryDAO inquiryDAO = InquiryDAO.getInstance();
          inquiryDAO.insertInquiry(inquiryVO);

          
//          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//          dispatcher.forward(request, response);
          
          response.sendRedirect(url);
          
   }

}