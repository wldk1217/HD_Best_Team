package com.kosa.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.entity.CategoryVO;
import com.kosa.entity.ProductVO;
import com.kosa.model.CategoryDAO;
import com.kosa.model.ProductDAO;

public class ProductAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/product/productAll.jsp";

		ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<ProductVO> productList = productDAO.ProductAll();
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		ArrayList<CategoryVO> categoryList = categoryDAO.viewCategory();
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
