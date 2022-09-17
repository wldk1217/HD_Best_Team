package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosa.dbUtil.DBConnection;
import com.kosa.entity.BasketVO;
import com.kosa.entity.OrdersVO;

import oracle.jdbc.OracleTypes;

public class BasketDAO {
	private BasketDAO() {
	}

	private static BasketDAO instance = new BasketDAO();

	public static BasketDAO getInstance() {
		return instance;
	}
	
	// 최초 장바구니 생성
	public int insertBasket(String memberId) {
		int result = 0;

		String runSP = "{ call basket_insert(?)}";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, memberId);
			callableStatement.executeUpdate();
			System.out.println("성공");
			result = 1;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}

	// 회원에 맞는 장바구니 찾기
	public int findBasketId(String memberId) {
		int result = 0;
		String run = "{ call find_basketid(?, ?) }";
	
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberId);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			
			try {
				callableStatement.execute();
				
				result = callableStatement.getInt(2);
				System.out.println("basketId 값 : " + result);

				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 상품 리스트 페이지에서 장바구니 담기
	public int insertBasketList(int productId, int basketId, int basketQuantity) {
		int result = 0;

		String runSP = "{ call basketlist_insert(?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setInt(1, productId);
			callableStatement.setInt(2, basketId);
			callableStatement.setInt(3, basketQuantity);
			callableStatement.executeUpdate();
			System.out.println("성공");
			result = 1;
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;
	}
}
