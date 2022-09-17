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
			} else {
				url = "tohomeServlet?command=product_sale";

				basketDAO.insertBasket(memberId, productId);

				int basketId = basketDAO.findBasketId(memberId);
				basketDAO.insertBasketList(productId, basketId, basketQuantity);
			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
