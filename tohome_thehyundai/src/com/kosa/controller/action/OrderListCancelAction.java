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
import com.kosa.entity.OrdersVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.OrdersDAO;

//취소된 주문내역 조회
public class OrderListCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/mypage/cancelOrder.jsp";

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
			OrdersDAO orderDAO = OrdersDAO.getInstance();
			ArrayList<OrdersVO> orderList = orderDAO.listOrder(loginUser);
			request.setAttribute("orderList", orderList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
