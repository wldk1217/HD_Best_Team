package com.kosa.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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
          //문의분야
          inquiryVO.setQuiryType(request.getParameter("depth1"));
          //문의날짜
          inquiryVO.setQuiryDate(Date.valueOf(LocalDate.now()));
          //문의내용
          inquiryVO.setQuiryContent(request.getParameter("cntn"));
          
          if(request.getParameter("uploading")==null) {
        	  inquiryVO.setQuiryImg("test");
          }
          else {
          }
          inquiryVO.setMember_memberId((String)session.getAttribute("memberId"));
          
            System.out.print(inquiryVO.getQuiryType());
            System.out.print(inquiryVO.getQuiryDate());
            System.out.print(inquiryVO.getQuiryContent());
            System.out.print(inquiryVO.getQuiryImg());
            System.out.print(inquiryVO.getMember_memberId());
            
          
          InquiryDAO inquiryDAO = InquiryDAO.getInstance();
          inquiryDAO.insertInquiry(inquiryVO);
      
          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
          dispatcher.forward(request, response);
          
   
          
   }

}