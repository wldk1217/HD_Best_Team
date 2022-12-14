/* 
 *  코드 작성자 : 민지아
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.BasketDAO;

public class BasketUpdateAction implements Action {

	// 장바구니 수량 수정
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=basket_list";

		int productId = Integer.parseInt(request.getParameter("productId"));
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		int count = Integer.parseInt(request.getParameter("count"));

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");

		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		basketDAO.updateBasket(productId, basketId, count);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
