package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.OrderListVO;
import com.kosa.entity.OrdersVO;
import com.kosa.model.OrdersDAO;

public class OrderListDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/orderListDetail.jsp";

		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");

		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		} else {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			OrdersDAO orderDAO = OrdersDAO.getInstance();
			ArrayList<OrderListVO> orderDetail = orderDAO.orderListDetail(orderId);
			request.setAttribute("orderId", orderId);
			request.setAttribute("orderDetail", orderDetail);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
