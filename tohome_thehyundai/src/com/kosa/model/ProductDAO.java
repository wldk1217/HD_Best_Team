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
			callableStatement.setInt(1, categoryId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				while (resultSet.next()) {
					ProductVO product = new ProductVO();
					product.setProductId(resultSet.getInt(1));
					product.setProductName(resultSet.getString(2));
					product.setProductPrice(resultSet.getInt(3));
					product.setProductImg(resultSet.getString(4));

					productList.add(product);
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

	// 전체상품 조회하기
	public ArrayList<ProductVO> ProductAll() {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		String runSP = "{ call product_all(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
				while (resultSet.next()) {
					ProductVO product = new ProductVO();
					product.setProductId(resultSet.getInt(1));
					product.setProductName(resultSet.getString(2));
					product.setProductPrice(resultSet.getInt(3));
					product.setProductImg(resultSet.getString(4));

					productList.add(product);
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
	
	// 상품 상세 정보 조회
	public ProductVO ProductDetail(int productId) {
		ProductVO product = null;

		String runSP = "{ call product_detail(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setInt(1, productId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				while (resultSet.next()) {
					product = new ProductVO();
					product.setProductId(resultSet.getInt(1));
					product.setProductName(resultSet.getString(2));
					product.setProductPrice(resultSet.getInt(3));
					product.setProductOrigin(resultSet.getString(4));
					product.setProductStock(resultSet.getInt(5));
					product.setProductDate(resultSet.getDate(6));
					product.setProductDetail(resultSet.getString(7));
					product.setProductImg(resultSet.getString(9));
					product.setProductImg(resultSet.getString(9));
					product.setCategory_categoryId(resultSet.getInt(10));
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
		return product;
	}

	// 세일 상품 목록 뿌려주기
	public ArrayList<ProductVO> ProductSale() {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		String runSP = "{ call product_all(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
				while (resultSet.next()) {
					ProductVO product = new ProductVO();
					product.setProductId(resultSet.getInt(1));
					product.setProductName(resultSet.getString(2));
					product.setProductPrice(resultSet.getInt(3));
					product.setProductImg(resultSet.getString(4));

					productList.add(product);
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
