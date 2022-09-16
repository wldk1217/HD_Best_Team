package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.MemberVO;
import com.kosa.entity.OrdersVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.MemberDAO;
import com.kosa.model.ProductDAO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/orders/orderList.jsp";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		int count = Integer.parseInt(request.getParameter("count"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int totalPrice = count * productPrice;
		
		if (memberId == null) {
			url = "tohomeServlet?command=login_form";
		} else {
			ProductDAO productDAO = ProductDAO.getInstance();
			ProductVO productVO = productDAO.ProductDetail(productId);
			request.setAttribute("productVO", productVO);
			
			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrderCount(count);
			ordersVO.setOrderState("주문대기");
			ordersVO.setTotalPrice(totalPrice);
			
			request.setAttribute("ordersVO", ordersVO);
			
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberVO memberVO = memberDAO.selectMember(memberId);
			request.setAttribute("memberVO", memberVO);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
