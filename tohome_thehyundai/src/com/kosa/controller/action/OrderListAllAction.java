/* 
 * 작성자 : 신기원
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.MemberVO;
import com.kosa.entity.OrdersVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.OrdersDAO;

public class OrderListAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="view/mypage/orderList.jsp";
		
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("memberId");
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		BasketDAO basketDAO = BasketDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("basketCount", basketDAO.countBasket(loginUser));
		
		
		if (loginUser == null) {
			url = "tohomeServlet?command=login_form";
		}else {
			//회원의 모든 주문 내역을 조회
			OrdersDAO orderDAO = OrdersDAO.getInstance();
			ArrayList<OrdersVO> orderList = 
	    		orderDAO.listOrder(loginUser);
	      request.setAttribute("orderList", orderList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
