/* 
 *  코드 작성자 : 민지아
 */
package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosa.dbUtil.DBConnection;
import com.kosa.entity.BasketVO;
import com.kosa.entity.OrdersVO;
import com.kosa.entity.ProductVO;

import oracle.jdbc.OracleTypes;

public class BasketDAO {
	private BasketDAO() {
	}

	private static BasketDAO instance = new BasketDAO();

	public static BasketDAO getInstance() {
		return instance;
	}
	
	// 최초 장바구니 생성
	public int insertBasket(String memberId, int productId) {
		int result = 0;
		int basketId = findBasketId(memberId);
		String runSP = "{ call basket_insert(?, ?, ?)}";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, memberId);
			callableStatement.setInt(2, basketId);
			callableStatement.setInt(3, productId);
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

	// 장바구니 개수 세기
	public int countBasket(String memberId) {
		int result = 0;
		String run = "{ call count_basket(?, ?) }";
	
		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberId);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			
			try {
				callableStatement.execute();
				
				result = callableStatement.getInt(2);
				System.out.println("total 값 : " + result);

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

	// 장바구니 리스트 조회
	public ArrayList<BasketVO> getBasketList(String memberId) {
		ArrayList<BasketVO> basketList = new ArrayList<BasketVO>();

		String runSP = "{ call basket_list(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.setString(1, memberId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				while (resultSet.next()) {
					BasketVO basket = new BasketVO();
					basket.setBasketId(resultSet.getInt(1));
					basket.setMemberId(resultSet.getString(2));
					basket.setProductId(resultSet.getInt(3));
					basket.setProductImg(resultSet.getString(4));
					basket.setProductName(resultSet.getString(5));
					basket.setProductPrice(resultSet.getInt(6));
					basket.setBasketQuantity(resultSet.getInt(7));

					basketList.add(basket);
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
		return basketList;
	}

	// 장바구니 삭제
	public void deleteBasket(int productId, int basketId) {
		String run = "{ call basket_delete(?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);
			callableStatement.setInt(1, productId);
			callableStatement.setInt(2, basketId);
			callableStatement.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 장바구니 수정
	public void updateBasket(int productId, int basketId, int basketQuantity) {
		String run = "{ call basket_update(?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);
			callableStatement.setInt(1, productId);
			callableStatement.setInt(2, basketId);
			callableStatement.setInt(3, basketQuantity);
			callableStatement.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
