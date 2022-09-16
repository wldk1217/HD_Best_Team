package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.OrdersVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.MemberDAO;
import com.kosa.model.OrdersDAO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "tohomeServlet?command=order_list";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		int count = Integer.parseInt(request.getParameter("count"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int totalPrice = count * productPrice;
		

		System.out.println(totalPrice);
		if (memberId == null) {
			url = "tohomeServlet?command=login_form";
		} else {

			OrdersDAO ordersDAO = OrdersDAO.getInstance();
			MemberDAO memberDAO = MemberDAO.getInstance();
			/*
			 * ArrayList<OrdersVO> orderInfoList = ordersDAO.orderInfoList(memberId,
			 * totalPrice); request.setAttribute("orderInfoList", orderInfoList);
			 */
		}
		response.sendRedirect(url);
	}

}
