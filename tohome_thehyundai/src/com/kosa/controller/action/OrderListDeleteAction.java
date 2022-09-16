package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.OrdersVO;
import com.kosa.model.OrdersDAO;

public class OrderListDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/orderList.jsp";
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		if (memberId == null) {
			url = "tohomeServlet?command=login_form";
		}  else {
	      OrdersDAO orderDAO = OrdersDAO.getInstance();
	      orderDAO.CancelOrder(memberId, orderId);

	      ArrayList<OrdersVO> orderList = 
	    		orderDAO.listOrder(memberId);
	      request.setAttribute("orderList", orderList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
