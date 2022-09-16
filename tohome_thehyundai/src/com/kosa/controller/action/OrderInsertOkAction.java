package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.OrdersVO;
import com.kosa.model.OrdersDAO;

public class OrderInsertOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/orders/orderListOk.jsp";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setPaymenttype(request.getParameter("paymentType"));
		ordersVO.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
		ordersVO.setOrderState("주문완료");

		OrdersDAO ordersDAO = OrdersDAO.getInstance();
		ordersDAO.insertOrders(ordersVO, memberId);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
