/*
 * 코드 작성자: 김민석
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.BasketDAO;
import com.kosa.model.InquiryDAO;


public class InquiryDeleteAction implements Action {

	//문의'삭제하기' 요청(request)를 받아 dao를 통해 삭제처리한 후 url 페이지로 forward 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=inquiry_list";
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		int cseq = Integer.parseInt(request.getParameter("cseq"));

		
		System.out.println(cseq);
		InquiryDAO inquiryDAO = InquiryDAO.getInstance();
		inquiryDAO.deleteInquiry(cseq);
		System.out.println("delete 성공");
		request.getRequestDispatcher(url).forward(request, response);
	}

}
