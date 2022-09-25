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
		
		//고객센터(문의)메인페이지 서블릿으로 이동
		String url = "tohomeServlet?command=inquiry_list";
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		//이전페이지에서 넘겨받은 "cseq" name의 값을 Integer값으로 파싱
		int cseq = Integer.parseInt(request.getParameter("cseq"));

		
		System.out.println(cseq);
		InquiryDAO inquiryDAO = InquiryDAO.getInstance();
		
		//inquiryDAO의 deleteInquiry메소드 실행을 통해 값 제거
		inquiryDAO.deleteInquiry(cseq);
		
		System.out.println("delete 성공");
		request.getRequestDispatcher(url).forward(request, response);
	}

}
