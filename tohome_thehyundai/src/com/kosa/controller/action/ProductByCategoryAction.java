/*
 * 작성자 : 민지아
 */
package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.BasketDAO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.ProductDAO;

public class ProductByCategoryAction implements Action {

	// 카테고리별 상품 조회
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/product/productByCategory.jsp";
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		HttpSession session = request.getSession();
		session.setAttribute("categoryId", categoryId);
		
		String memberId = (String) session.getAttribute("memberId");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> productList = productDAO.ProductByCategory(categoryId);
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		
		BasketDAO basketDAO = BasketDAO.getInstance();
		
		request.setAttribute("basketCount", basketDAO.countBasket(memberId));
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}