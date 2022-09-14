package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.entity.ProductVO;
import com.kosa.model.ProductDAO;

public class ProductByCategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/product/productByCategory.jsp";

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> productList = productDAO.ProductByCategory(categoryId);

		request.setAttribute("productList", productList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
