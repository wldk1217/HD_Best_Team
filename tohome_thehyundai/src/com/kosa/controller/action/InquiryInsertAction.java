/*
 * 코드작성자 : 김민석
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.InquiryVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.InquiryDAO;

public class InquiryInsertAction implements Action {

	//문의'입력하기' 요청(request)를 받아 dao를 통해 입력처리한 후 url 페이지로 forward 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/inquiry/mtmInqrComplete.jsp";

		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);

		InquiryVO inquiryVO = new InquiryVO();
		// 문의분야
		inquiryVO.setQuiryType(request.getParameter("depth1"));
		// 문의날짜
		inquiryVO.setQuiryDate(Date.valueOf(LocalDate.now()));
		// 문의내용
		inquiryVO.setQuiryContent(request.getParameter("cntn"));

		if (request.getParameter("uploading") == null) {
			inquiryVO.setQuiryImg("test");
		} else {
		}

		inquiryVO.setMember_memberId((String) session.getAttribute("memberId"));

		System.out.print(inquiryVO.getQuiryType());
		System.out.print(inquiryVO.getQuiryDate());
		System.out.print(inquiryVO.getQuiryContent());
		System.out.print(inquiryVO.getQuiryImg());
		System.out.print(inquiryVO.getMember_memberId());

		InquiryDAO inquiryDAO = InquiryDAO.getInstance();
		inquiryDAO.insertInquiry(inquiryVO);
		System.out.println("insert 성공");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}