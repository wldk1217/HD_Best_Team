package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.kosa.dbUtil.DBConnection;
import com.kosa.entity.OrdersVO;

import oracle.jdbc.OracleTypes;

public class OrdersDAO {
	
	private OrdersDAO() {
	}

	private static OrdersDAO instance = new OrdersDAO();

	public static OrdersDAO getInstance() {
		return instance;
	}
	
	
	/* 주문 테스트시 사용 */
	public static void main(String[] args) {
		OrdersDAO dao = OrdersDAO.getInstance();
		ArrayList<OrdersVO> arr = dao.listOrder("admin12");
		System.out.println(arr);
	}
	
	//주문 내역 조회
	public ArrayList<OrdersVO> listOrder(String memberID) {
		ArrayList<OrdersVO> orderList = new ArrayList<OrdersVO>();

		String run = "{call orderlist_select(?, ?)}";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(run);

			callableStatement.setString(1, memberID);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				while (resultSet.next()) {
					OrdersVO ordersVO = new OrdersVO();
				
					ordersVO.setOrderDate(resultSet.getDate(1));
					ordersVO.setOrderCount(resultSet.getInt(2));
					ordersVO.setOrderState(resultSet.getString(3));
					ordersVO.setOrderId(resultSet.getInt(4));
					ordersVO.setTotalPrice(resultSet.getInt(5));
					orderList.add(ordersVO);
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
		}
		return orderList;

	}
}
