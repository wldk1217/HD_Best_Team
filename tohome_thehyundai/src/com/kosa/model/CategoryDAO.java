package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kosa.dbUtil.DBConnection;
import com.kosa.dbUtil.DbUtil;

import oracle.jdbc.OracleTypes;

public class CategoryDAO {

	public static void main(String[] args) {

		String runSP = "{ call category_pro(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
				
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String type = resultSet.getString(2);
					System.out.println(id + " " + type);
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

	}

}