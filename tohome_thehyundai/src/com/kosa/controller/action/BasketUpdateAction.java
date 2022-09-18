package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.model.BasketDAO;

public class BasketUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=basket_list";
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		int basketId = Integer.parseInt(request.getParameter("basketId"));
		int basketQuantity = Integer.parseInt(request.getParameter("basketQuantity"));

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		
		basketDAO.updateBasket(productId, basketId, basketQuantity);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
