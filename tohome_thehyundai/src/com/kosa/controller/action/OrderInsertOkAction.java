/* 
 *  코드 작성자 : 민지아
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.BasketVO;
import com.kosa.entity.OrdersVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.OrdersDAO;

public class OrderInsertOkAction implements Action {

	// 주문 insert 실행
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/orders/orderListOk.jsp";

		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		int basketOk = Integer.parseInt(request.getParameter("basketOk"));
		
		OrdersVO ordersVO = new OrdersVO();

		ordersVO.setPaymenttype(request.getParameter("paymentType"));
		ordersVO.setTotalPrice(Integer.parseInt(request.getParameter("totalPrice")));
		ordersVO.setOrderState("주문완료");
		
		// 즉시주문 주문 insert
		if (basketOk == 0) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
			
			OrdersDAO ordersDAO = OrdersDAO.getInstance();
			ordersDAO.insertOrders(ordersVO, memberId);
			int orderId = ordersDAO.findOrdersId();
			ordersDAO.insertOrderList(productId, orderId, orderQuantity);
			
		// 장바구니에서 주문 insert	
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<BasketVO> basketList = (ArrayList<BasketVO>) session.getAttribute("basketList");
			request.setAttribute("basketList", basketList);
			
			OrdersDAO ordersDAO = OrdersDAO.getInstance();
			ordersDAO.insertOrders(ordersVO, memberId); 
			int orderId = ordersDAO.findOrdersId();
			
			for(int i = 0; i < basketList.size(); i++) {
				ordersDAO.insertOrderList(basketList.get(i).getProductId(), orderId, basketList.get(i).getBasketQuantity());
			}
			
			// 장바구니 주문 시 sessoin에서 장바구니 clear 및 장바구니리스트 삭제
			BasketDAO basketDAO = BasketDAO.getInstance();
			for(int i = 0; i < basketList.size(); i++) {
				basketDAO.deleteBasket(basketList.get(i).getProductId(), basketList.get(i).getBasketId());
			}
			
			session.removeAttribute("basketList");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
