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

import com.kosa.entity.MemberVO;
import com.kosa.model.BasketDAO;

public class BasketInsertAction implements Action {

	// 장바구니 상품 담기
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=basket_list";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		int onlyinsert = Integer.parseInt(request.getParameter("onlyinsert"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int basketQuantity = 1;

		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));

		if (memberId == null) {
			url = "tohomeServlet?command=login_form";
		} else {
			// 카테고리별 상품, 전체상품, 신상품, 세일상품 별 장바구니에 상품 1개씩 담기
			if (onlyinsert == 1) {
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				url = "tohomeServlet?command=product_by_category&categoryId=" + categoryId;

				basketDAO.insertBasket(memberId, productId);

				int basketId = basketDAO.findBasketId(memberId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			} else if (onlyinsert == 2) {
				url = "tohomeServlet?command=product_All";

				basketDAO.insertBasket(memberId, productId);

				int basketId = basketDAO.findBasketId(memberId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			} else if (onlyinsert == 3) {
				url = "tohomeServlet?command=product_new";

				basketDAO.insertBasket(memberId, productId);

				int basketId = basketDAO.findBasketId(memberId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			} else if (onlyinsert == 4) {
				url = "tohomeServlet?command=product_sale";

				basketDAO.insertBasket(memberId, productId);

				int basketId = basketDAO.findBasketId(memberId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			} else {
				url = "tohomeServlet?command=basket_list";
				basketQuantity = Integer.parseInt(request.getParameter("count"));
				int basketId = basketDAO.findBasketId(memberId);

				basketDAO.insertBasket(memberId, productId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
