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
import com.kosa.entity.MemberVO;
import com.kosa.entity.OrdersVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.MemberDAO;
import com.kosa.model.ProductDAO;

public class OrderInsertAction implements Action {

	// 주문정보 확인
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/orders/orderList.jsp";

		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("memberId");
		int count = Integer.parseInt(request.getParameter("count"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		int totalPrice = count * productPrice;
		int basketOrder = Integer.parseInt(request.getParameter("basketOrder"));
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		
		// 로그인 안되어 있을 시 로그인 폼으로
		if (memberId == null) {
			url = "tohomeServlet?command=login_form";
		} 
		
		// 장바구니에서 주문하기 버튼 눌러 주문하기
		if (basketOrder == 1) {
			// 장바구니 리스트 세션에서 가져오기
			@SuppressWarnings("unchecked")
			ArrayList<BasketVO> basketList = (ArrayList<BasketVO>) session.getAttribute("basketList");
			request.setAttribute("basketList", basketList);
			
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberVO memberVO = memberDAO.selectMember(memberId);
			request.setAttribute("memberVO", memberVO);
			
			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrderState("주문대기");
			
			// 장바구니에 담긴 상품들 총 가격 구하기
			int totalPriceBasket = 0;
			for(int i = 0; i < basketList.size(); i++) {
				totalPriceBasket += basketList.get(i).getProductPrice() * basketList.get(i).getBasketQuantity();
			}
			
			ProductDAO productDAO = ProductDAO.getInstance();
			ProductVO productVO = productDAO.ProductDetail(productId);
			request.setAttribute("productVO", productVO);
			
			ordersVO.setTotalPrice(totalPriceBasket);
			request.setAttribute("ordersVO", ordersVO);
			
			url = "view/orders/orderListByBasket.jsp";
			
		// 즉시 주문하기 정보 확인
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
