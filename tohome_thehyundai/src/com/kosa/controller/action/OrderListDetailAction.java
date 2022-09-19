package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.OrderListVO;
import com.kosa.entity.OrdersVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.OrdersDAO;

//주문내역 상세정보
public class OrderListDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/orderListDetail.jsp";

		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		BasketDAO basketDAO = BasketDAO.getInstance();
		
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("basketCount", basketDAO.countBasket(loginUser));

		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		} else {
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			OrdersDAO orderDAO = OrdersDAO.getInstance();
			ArrayList<OrderListVO> orderDetail = orderDAO.orderListDetail(orderId);
			
			//주문 상품들의 총 결제 금액
			int total = 0;
			for (OrderListVO orderListVO : orderDetail) {
				total += orderListVO.getProduct().getProductPrice()*orderListVO.getOrderQuantity();
			}
			request.setAttribute("orderId", orderId);
			request.setAttribute("orderDetail", orderDetail);
			request.setAttribute("total", total);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
