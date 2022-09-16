package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.MemberVO;
import com.kosa.entity.OrdersVO;
import com.kosa.model.OrdersDAO;

public class OrderListAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="view/mypage/orderList.jsp";
		
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");

		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		}  else {
	      OrdersDAO orderDAO = OrdersDAO.getInstance();
	      ArrayList<OrdersVO> orderList = 
	    		orderDAO.listOrder(loginUser);
	      request.setAttribute("title", "총 주문 내역");
	      request.setAttribute("orderList", orderList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
