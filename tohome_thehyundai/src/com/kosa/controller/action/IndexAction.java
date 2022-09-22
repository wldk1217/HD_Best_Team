/* 
 *  코드 작성자 : 민지아
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;



public class IndexAction implements Action {

	// 메인페이지 카테고리 리스트 조회
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		
		// 카테고리 리스트 조회 코드 -> 모든 페이지 헤더에 있으므로 모든 Action에 추가
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		
		request.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
