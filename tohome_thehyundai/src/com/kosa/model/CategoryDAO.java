package com.kosa.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kosa.dbUtil.DBConnection;
import com.kosa.dbUtil.DbUtil;
import com.kosa.entity.CategoryVO;

import oracle.jdbc.OracleTypes;

public class CategoryDAO {
	
	private CategoryDAO() {
	}

	private static CategoryDAO instance = new CategoryDAO();

	public static CategoryDAO getInstance() {
		return instance;
	}
	
	// 카테고리 항목 화면에 뿌려주기
	public ArrayList<CategoryVO> viewCategory() {
		ArrayList<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		
		String runSP = "{ call category_pro(?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
				
				while (resultSet.next()) {	
					CategoryVO category = new CategoryVO();
					category.setCategoryId(resultSet.getInt(1));
					category.setCategoryType(resultSet.getString(2));
					
					categoryList.add(category);
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
		return categoryList;
	}
}