/*
 * 작성자 : 민지아
 */
package com.kosa.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.model.ProductDAO;
import com.kosa.entity.*;

public class ProductDetailAction implements Action {

	// 상품 상세페이지 조회
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/product/productDetail.jsp";

		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductDAO productDAO = ProductDAO.getInstance(); 
		ProductVO productVO = productDAO.ProductDetail(productId);
		
		String shortDetail = productVO.getProductDetail().split("\\.")[0];
		
		request.setAttribute("productVO", productVO);
		request.setAttribute("shortDetail", shortDetail);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
