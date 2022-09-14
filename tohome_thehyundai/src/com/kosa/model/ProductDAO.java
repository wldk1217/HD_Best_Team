package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosa.dbUtil.DBConnection;
import com.kosa.entity.ProductVO;

import oracle.jdbc.OracleTypes;

public class ProductDAO {
	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	// 카테고리 별 상품 화면에 뿌려주기
	public ArrayList<ProductVO> ProductByCategory(int categoryId) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		String runSP = "{ call product_by_category(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, categoryId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				System.out.println("before amu");
				while (resultSet.next()) {
					
					System.out.println("amu");
					ProductVO product = new ProductVO();
					product.setProductName(resultSet.getString(1));
					product.setProductPrice(resultSet.getInt(2));
					product.setProductImg(resultSet.getString(3));
			
					productList.add(product);
					
					System.out.println(product.getProductName());
				}

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return productList;
	}
}
