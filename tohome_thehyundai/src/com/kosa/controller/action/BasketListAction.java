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
import com.kosa.model.BasketDAO;

public class BasketListAction implements Action {

	// 장바구니 리스트 조회
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/orders/basketList.jsp";
		
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("memberId");
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		
	    if (memberId == null) {
	      url = "tohomeServlet?command=login_form";
	    } else {
	    	ArrayList<BasketVO> basketList = basketDAO.getBasketList(memberId);
	    	
	    	// 장바구니 리스트 개수 조회
	    	request.setAttribute("lastSize", basketList.size() - 1);
	    	request.setAttribute("basketList", basketList);
	    	session.setAttribute("basketList", basketList);
	    }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
